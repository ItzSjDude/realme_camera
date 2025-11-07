package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class Ac3Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int HEADER_SIZE = 128;
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private com.google.android.exoplayer2.Format format;
    private final com.google.android.exoplayer2.util.ParsableBitArray headerScratchBits;
    private final com.google.android.exoplayer2.util.ParsableByteArray headerScratchBytes;
    private final java.lang.String language;
    private boolean lastByteWas0B;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;
    private java.lang.String trackFormatId;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public Ac3Reader() {
        this(null);
    }

    public Ac3Reader(java.lang.String str) {
        this.headerScratchBits = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[128]);
        this.headerScratchBytes = new com.google.android.exoplayer2.util.ParsableByteArray(this.headerScratchBits.data);
        this.state = 0;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWas0B = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.trackFormatId = trackIdGenerator.getFormatId();
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
                    }
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.data, 128)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 128);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
                this.headerScratchBytes.data[0] = 11;
                this.headerScratchBytes.data[1] = 119;
                this.bytesRead = 2;
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
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                return false;
            }
            if (!this.lastByteWas0B) {
                this.lastByteWas0B = parsableByteArray.readUnsignedByte() == 11;
            } else {
                int unsignedByte = parsableByteArray.readUnsignedByte();
                if (unsignedByte == 119) {
                    this.lastByteWas0B = false;
                    return true;
                }
                this.lastByteWas0B = unsignedByte == 11;
            }
        }
    }

    private void parseHeader() {
        this.headerScratchBits.setPosition(0);
        com.google.android.exoplayer2.audio.Ac3Util.SyncFrameInfo ac3SyncframeInfo = com.google.android.exoplayer2.audio.Ac3Util.parseAc3SyncframeInfo(this.headerScratchBits);
        if (this.format == null || ac3SyncframeInfo.channelCount != this.format.channelCount || ac3SyncframeInfo.sampleRate != this.format.sampleRate || ac3SyncframeInfo.mimeType != this.format.sampleMimeType) {
            this.format = com.google.android.exoplayer2.Format.createAudioSampleFormat(this.trackFormatId, ac3SyncframeInfo.mimeType, null, -1, -1, ac3SyncframeInfo.channelCount, ac3SyncframeInfo.sampleRate, null, null, 0, this.language);
            this.output.format(this.format);
        }
        this.sampleSize = ac3SyncframeInfo.frameSize;
        this.sampleDurationUs = (ac3SyncframeInfo.sampleCount * 1000000) / this.format.sampleRate;
    }
}
