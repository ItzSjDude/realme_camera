package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class Ac4Reader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int STATE_FINDING_SYNC = 0;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private int bytesRead;
    private com.google.android.exoplayer2.Format format;
    private boolean hasCRC;
    private final com.google.android.exoplayer2.util.ParsableBitArray headerScratchBits;
    private final com.google.android.exoplayer2.util.ParsableByteArray headerScratchBytes;
    private final java.lang.String language;
    private boolean lastByteWasAC;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;
    private java.lang.String trackFormatId;

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public Ac4Reader() {
        this(null);
    }

    public Ac4Reader(java.lang.String str) {
        this.headerScratchBits = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[16]);
        this.headerScratchBytes = new com.google.android.exoplayer2.util.ParsableByteArray(this.headerScratchBits.data);
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWasAC = false;
        this.hasCRC = false;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.lastByteWasAC = false;
        this.hasCRC = false;
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
                } else if (continueRead(parsableByteArray, this.headerScratchBytes.data, 16)) {
                    parseHeader();
                    this.headerScratchBytes.setPosition(0);
                    this.output.sampleData(this.headerScratchBytes, 16);
                    this.state = 2;
                }
            } else if (skipToNextSync(parsableByteArray)) {
                this.state = 1;
                this.headerScratchBytes.data[0] = -84;
                this.headerScratchBytes.data[1] = (byte) (this.hasCRC ? 65 : 64);
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
        int unsignedByte;
        while (true) {
            if (parsableByteArray.bytesLeft() <= 0) {
                return false;
            }
            if (!this.lastByteWasAC) {
                this.lastByteWasAC = parsableByteArray.readUnsignedByte() == 172;
            } else {
                unsignedByte = parsableByteArray.readUnsignedByte();
                this.lastByteWasAC = unsignedByte == 172;
                if (unsignedByte == 64 || unsignedByte == 65) {
                    break;
                }
            }
        }
        this.hasCRC = unsignedByte == 65;
        return true;
    }

    private void parseHeader() {
        this.headerScratchBits.setPosition(0);
        com.google.android.exoplayer2.audio.Ac4Util.SyncFrameInfo ac4SyncframeInfo = com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeInfo(this.headerScratchBits);
        if (this.format == null || ac4SyncframeInfo.channelCount != this.format.channelCount || ac4SyncframeInfo.sampleRate != this.format.sampleRate || !com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(this.format.sampleMimeType)) {
            this.format = com.google.android.exoplayer2.Format.createAudioSampleFormat(this.trackFormatId, com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4, null, -1, -1, ac4SyncframeInfo.channelCount, ac4SyncframeInfo.sampleRate, null, null, 0, this.language);
            this.output.format(this.format);
        }
        this.sampleSize = ac4SyncframeInfo.frameSize;
        this.sampleDurationUs = (ac4SyncframeInfo.sampleCount * 1000000) / this.format.sampleRate;
    }
}
