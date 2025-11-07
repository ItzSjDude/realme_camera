package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class MpegAudioReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int HEADER_SIZE = 4;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_FRAME = 2;
    private static final int STATE_READING_HEADER = 1;
    private java.lang.String formatId;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final com.google.android.exoplayer2.extractor.MpegAudioHeader header;
    private final com.google.android.exoplayer2.util.ParsableByteArray headerScratch;
    private final java.lang.String language;
    private boolean lastByteWasFF;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private int state;
    private long timeUs;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public MpegAudioReader() {
        this(null);
    }

    public MpegAudioReader(java.lang.String str) {
        this.state = 0;
        this.headerScratch = new com.google.android.exoplayer2.util.ParsableByteArray(4);
        this.headerScratch.data[0] = -1;
        this.header = new com.google.android.exoplayer2.extractor.MpegAudioHeader();
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
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
            if (i_renamed == 0) {
                findHeader(parsableByteArray);
            } else if (i_renamed == 1) {
                readHeaderRemainder(parsableByteArray);
            } else if (i_renamed == 2) {
                readFrameRemainder(parsableByteArray);
            } else {
                throw new java.lang.IllegalStateException();
            }
        }
    }

    private void findHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        int iLimit = parsableByteArray.limit();
        for (int position = parsableByteArray.getPosition(); position < iLimit; position++) {
            boolean z_renamed = (bArr[position] & 255) == 255;
            boolean z2 = this.lastByteWasFF && (bArr[position] & 224) == 224;
            this.lastByteWasFF = z_renamed;
            if (z2) {
                parsableByteArray.setPosition(position + 1);
                this.lastByteWasFF = false;
                this.headerScratch.data[1] = bArr[position];
                this.frameBytesRead = 2;
                this.state = 1;
                return;
            }
        }
        parsableByteArray.setPosition(iLimit);
    }

    private void readHeaderRemainder(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), 4 - this.frameBytesRead);
        parsableByteArray.readBytes(this.headerScratch.data, this.frameBytesRead, iMin);
        this.frameBytesRead += iMin;
        if (this.frameBytesRead < 4) {
            return;
        }
        this.headerScratch.setPosition(0);
        if (!com.google.android.exoplayer2.extractor.MpegAudioHeader.populateHeader(this.headerScratch.readInt(), this.header)) {
            this.frameBytesRead = 0;
            this.state = 1;
            return;
        }
        this.frameSize = this.header.frameSize;
        if (!this.hasOutputFormat) {
            this.frameDurationUs = (this.header.samplesPerFrame * 1000000) / this.header.sampleRate;
            this.output.format(com.google.android.exoplayer2.Format.createAudioSampleFormat(this.formatId, this.header.mimeType, null, -1, 4096, this.header.channels, this.header.sampleRate, null, null, 0, this.language));
            this.hasOutputFormat = true;
        }
        this.headerScratch.setPosition(0);
        this.output.sampleData(this.headerScratch, 4);
        this.state = 2;
    }

    private void readFrameRemainder(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), this.frameSize - this.frameBytesRead);
        this.output.sampleData(parsableByteArray, iMin);
        this.frameBytesRead += iMin;
        int i_renamed = this.frameBytesRead;
        int i2 = this.frameSize;
        if (i_renamed < i2) {
            return;
        }
        this.output.sampleMetadata(this.timeUs, 1, i2, 0, null);
        this.timeUs += this.frameDurationUs;
        this.frameBytesRead = 0;
        this.state = 0;
    }
}
