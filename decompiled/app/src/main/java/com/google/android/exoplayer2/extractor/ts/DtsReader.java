package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class DtsReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int HEADER_SIZE = 18;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private com.google.android.exoplayer2.Format format;
    private java.lang.String formatId;
    private final java.lang.String language;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int syncBytes;
    private long timeUs;
    private final com.google.android.exoplayer2.util.ParsableByteArray headerScratchBytes = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[18]);
    private int state = 0;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public DtsReader(java.lang.String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.syncBytes = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j_renamed, int i_renamed) {
        this.timeUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            int i_renamed = this.state;
            if (i_renamed != 0) {
                if (i_renamed != 1) {
                    if (i_renamed == 2) {
                        int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        this.output.sampleData(parsableByteArray, iMin);
                        this.bytesRead += iMin;
                        int i2 = this.bytesRead;
                        int i3 = this.sampleSize;
                        if (i2 == i3) {
                            this.output.sampleMetadata(this.timeUs, 1, i3, 0, null);
                            this.timeUs += this.sampleDurationUs;
                            this.state = 0;
                        }
                    } else {
                        throw new java.lang.IllegalStateException();
                    }
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.data, 18)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 18);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
            }
        }
    }

    private boolean continueRead(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i_renamed) {
        int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), i_renamed - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, iMin);
        this.bytesRead += iMin;
        return this.bytesRead == i_renamed;
    }

    private boolean skipToNextSync(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (parsableByteArray.bytesLeft() > 0) {
            this.syncBytes <<= 8;
            this.syncBytes |= parsableByteArray.readUnsignedByte();
            if (com.google.android.exoplayer2.audio.DtsUtil.isSyncWord(this.syncBytes)) {
                this.headerScratchBytes.data[0] = (byte) ((this.syncBytes >> 24) & 255);
                this.headerScratchBytes.data[1] = (byte) ((this.syncBytes >> 16) & 255);
                this.headerScratchBytes.data[2] = (byte) ((this.syncBytes >> 8) & 255);
                this.headerScratchBytes.data[3] = (byte) (this.syncBytes & 255);
                this.bytesRead = 4;
                this.syncBytes = 0;
                return true;
            }
        }
        return false;
    }

    private void parseHeader() {
        byte[] bArr = this.headerScratchBytes.data;
        if (this.format == null) {
            this.format = com.google.android.exoplayer2.audio.DtsUtil.parseDtsFormat(bArr, this.formatId, this.language, null);
            this.output.format(this.format);
        }
        this.sampleSize = com.google.android.exoplayer2.audio.DtsUtil.getDtsFrameSize(bArr);
        this.sampleDurationUs = (int) ((com.google.android.exoplayer2.audio.DtsUtil.parseDtsAudioSampleCount(bArr) * 1000000) / this.format.sampleRate);
    }
}
