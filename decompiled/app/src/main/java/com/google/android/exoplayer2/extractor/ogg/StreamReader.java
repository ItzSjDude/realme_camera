package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
abstract class StreamReader {
    private static final int STATE_END_OF_INPUT = 3;
    private static final int STATE_READ_HEADERS = 0;
    private static final int STATE_READ_PAYLOAD = 2;
    private static final int STATE_SKIP_HEADERS = 1;
    private long currentGranule;
    private com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput;
    private boolean formatSet;
    private long lengthOfReadPacket;
    private final com.google.android.exoplayer2.extractor.ogg.OggPacket oggPacket = new com.google.android.exoplayer2.extractor.ogg.OggPacket();
    private com.google.android.exoplayer2.extractor.ogg.OggSeeker oggSeeker;
    private long payloadStartPosition;
    private int sampleRate;
    private boolean seekMapSet;
    private com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData;
    private int state;
    private long targetGranule;
    private com.google.android.exoplayer2.extractor.TrackOutput trackOutput;

    protected abstract long preparePayload(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray);

    protected abstract boolean readHeaders(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j_renamed, com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData setupData) throws java.lang.InterruptedException, java.io.IOException;

    static class SetupData {
        com.google.android.exoplayer2.Format format;
        com.google.android.exoplayer2.extractor.ogg.OggSeeker oggSeeker;

        SetupData() {
        }
    }

    void init(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.TrackOutput trackOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = trackOutput;
        reset(true);
    }

    protected void reset(boolean z_renamed) {
        if (z_renamed) {
            this.setupData = new com.google.android.exoplayer2.extractor.ogg.StreamReader.SetupData();
            this.payloadStartPosition = 0L;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.targetGranule = -1L;
        this.currentGranule = 0L;
    }

    final void seek(long j_renamed, long j2) {
        this.oggPacket.reset();
        if (j_renamed == 0) {
            reset(!this.seekMapSet);
        } else if (this.state != 0) {
            this.targetGranule = this.oggSeeker.startSeek(j2);
            this.state = 2;
        }
    }

    final int read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed = this.state;
        if (i_renamed == 0) {
            return readHeaders(extractorInput);
        }
        if (i_renamed != 1) {
            if (i_renamed == 2) {
                return readPayload(extractorInput, positionHolder);
            }
            throw new java.lang.IllegalStateException();
        }
        extractorInput.skipFully((int) this.payloadStartPosition);
        this.state = 2;
        return 0;
    }

    private int readHeaders(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        boolean headers = true;
        while (headers) {
            if (!this.oggPacket.populate(extractorInput)) {
                this.state = 3;
                return -1;
            }
            this.lengthOfReadPacket = extractorInput.getPosition() - this.payloadStartPosition;
            headers = readHeaders(this.oggPacket.getPayload(), this.payloadStartPosition, this.setupData);
            if (headers) {
                this.payloadStartPosition = extractorInput.getPosition();
            }
        }
        this.sampleRate = this.setupData.format.sampleRate;
        if (!this.formatSet) {
            this.trackOutput.format(this.setupData.format);
            this.formatSet = true;
        }
        if (this.setupData.oggSeeker != null) {
            this.oggSeeker = this.setupData.oggSeeker;
        } else if (extractorInput.getLength() == -1) {
            this.oggSeeker = new com.google.android.exoplayer2.extractor.ogg.StreamReader.UnseekableOggSeeker();
        } else {
            com.google.android.exoplayer2.extractor.ogg.OggPageHeader pageHeader = this.oggPacket.getPageHeader();
            this.oggSeeker = new com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker(this.payloadStartPosition, extractorInput.getLength(), this, pageHeader.headerSize + pageHeader.bodySize, pageHeader.granulePosition, (pageHeader.type & 4) != 0);
        }
        this.setupData = null;
        this.state = 2;
        this.oggPacket.trimPayload();
        return 0;
    }

    private int readPayload(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, com.google.android.exoplayer2.extractor.PositionHolder positionHolder) throws java.lang.InterruptedException, java.io.IOException {
        long j_renamed = this.oggSeeker.read(extractorInput);
        if (j_renamed >= 0) {
            positionHolder.position = j_renamed;
            return 1;
        }
        if (j_renamed < -1) {
            onSeekEnd(-(j_renamed + 2));
        }
        if (!this.seekMapSet) {
            this.extractorOutput.seekMap(this.oggSeeker.createSeekMap());
            this.seekMapSet = true;
        }
        if (this.lengthOfReadPacket > 0 || this.oggPacket.populate(extractorInput)) {
            this.lengthOfReadPacket = 0L;
            com.google.android.exoplayer2.util.ParsableByteArray payload = this.oggPacket.getPayload();
            long jPreparePayload = preparePayload(payload);
            if (jPreparePayload >= 0) {
                long j2 = this.currentGranule;
                if (j2 + jPreparePayload >= this.targetGranule) {
                    long jConvertGranuleToTime = convertGranuleToTime(j2);
                    this.trackOutput.sampleData(payload, payload.limit());
                    this.trackOutput.sampleMetadata(jConvertGranuleToTime, 1, payload.limit(), 0, null);
                    this.targetGranule = -1L;
                }
            }
            this.currentGranule += jPreparePayload;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    protected long convertGranuleToTime(long j_renamed) {
        return (j_renamed * 1000000) / this.sampleRate;
    }

    protected long convertTimeToGranule(long j_renamed) {
        return (this.sampleRate * j_renamed) / 1000000;
    }

    protected void onSeekEnd(long j_renamed) {
        this.currentGranule = j_renamed;
    }

    private static final class UnseekableOggSeeker implements com.google.android.exoplayer2.extractor.ogg.OggSeeker {
        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long read(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
            return -1L;
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public long startSeek(long j_renamed) {
            return 0L;
        }

        private UnseekableOggSeeker() {
        }

        @Override // com.google.android.exoplayer2.extractor.ogg.OggSeeker
        public com.google.android.exoplayer2.extractor.SeekMap createSeekMap() {
            return new com.google.android.exoplayer2.extractor.SeekMap.Unseekable(-9223372036854775807L);
        }
    }
}
