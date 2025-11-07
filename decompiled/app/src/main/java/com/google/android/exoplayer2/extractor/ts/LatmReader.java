package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class LatmReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int INITIAL_BUFFER_SIZE = 1024;
    private static final int STATE_FINDING_SYNC_1 = 0;
    private static final int STATE_FINDING_SYNC_2 = 1;
    private static final int STATE_READING_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 3;
    private static final int SYNC_BYTE_FIRST = 86;
    private static final int SYNC_BYTE_SECOND = 224;
    private int audioMuxVersionA;
    private int bytesRead;
    private int channelCount;
    private com.google.android.exoplayer2.Format format;
    private java.lang.String formatId;
    private int frameLengthType;
    private final java.lang.String language;
    private int numSubframes;
    private long otherDataLenBits;
    private boolean otherDataPresent;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private long sampleDurationUs;
    private int sampleRateHz;
    private int sampleSize;
    private int secondHeaderByte;
    private int state;
    private boolean streamMuxRead;
    private long timeUs;
    private final com.google.android.exoplayer2.util.ParsableByteArray sampleDataBuffer = new com.google.android.exoplayer2.util.ParsableByteArray(1024);
    private final com.google.android.exoplayer2.util.ParsableBitArray sampleBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(this.sampleDataBuffer.data);

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public LatmReader(java.lang.String str) {
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.streamMuxRead = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.formatId = trackIdGenerator.getFormatId();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j_renamed, int i_renamed) {
        this.timeUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        while (parsableByteArray.bytesLeft() > 0) {
            int i_renamed = this.state;
            if (i_renamed != 0) {
                if (i_renamed == 1) {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    if ((unsignedByte & 224) == 224) {
                        this.secondHeaderByte = unsignedByte;
                        this.state = 2;
                    } else if (unsignedByte != 86) {
                        this.state = 0;
                    }
                } else if (i_renamed == 2) {
                    this.sampleSize = ((this.secondHeaderByte & (-225)) << 8) | parsableByteArray.readUnsignedByte();
                    if (this.sampleSize > this.sampleDataBuffer.data.length) {
                        resetBufferForSize(this.sampleSize);
                    }
                    this.bytesRead = 0;
                    this.state = 3;
                } else if (i_renamed == 3) {
                    int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                    parsableByteArray.readBytes(this.sampleBitArray.data, this.bytesRead, iMin);
                    this.bytesRead += iMin;
                    if (this.bytesRead == this.sampleSize) {
                        this.sampleBitArray.setPosition(0);
                        parseAudioMuxElement(this.sampleBitArray);
                        this.state = 0;
                    }
                } else {
                    throw new java.lang.IllegalStateException();
                }
            } else if (parsableByteArray.readUnsignedByte() == 86) {
                this.state = 1;
            }
        }
    }

    private void parseAudioMuxElement(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        if (!parsableBitArray.readBit()) {
            this.streamMuxRead = true;
            parseStreamMuxConfig(parsableBitArray);
        } else if (!this.streamMuxRead) {
            return;
        }
        if (this.audioMuxVersionA == 0) {
            if (this.numSubframes != 0) {
                throw new com.google.android.exoplayer2.ParserException();
            }
            parsePayloadMux(parsableBitArray, parsePayloadLengthInfo(parsableBitArray));
            if (this.otherDataPresent) {
                parsableBitArray.skipBits((int) this.otherDataLenBits);
                return;
            }
            return;
        }
        throw new com.google.android.exoplayer2.ParserException();
    }

    private void parseStreamMuxConfig(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        boolean bit;
        int bits = parsableBitArray.readBits(1);
        this.audioMuxVersionA = bits == 1 ? parsableBitArray.readBits(1) : 0;
        if (this.audioMuxVersionA == 0) {
            if (bits == 1) {
                latmGetValue(parsableBitArray);
            }
            if (!parsableBitArray.readBit()) {
                throw new com.google.android.exoplayer2.ParserException();
            }
            this.numSubframes = parsableBitArray.readBits(6);
            int bits2 = parsableBitArray.readBits(4);
            int bits3 = parsableBitArray.readBits(3);
            if (bits2 != 0 || bits3 != 0) {
                throw new com.google.android.exoplayer2.ParserException();
            }
            if (bits == 0) {
                int position = parsableBitArray.getPosition();
                int audioSpecificConfig = parseAudioSpecificConfig(parsableBitArray);
                parsableBitArray.setPosition(position);
                byte[] bArr = new byte[(audioSpecificConfig + 7) / 8];
                parsableBitArray.readBits(bArr, 0, audioSpecificConfig);
                com.google.android.exoplayer2.Format formatCreateAudioSampleFormat = com.google.android.exoplayer2.Format.createAudioSampleFormat(this.formatId, com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC, null, -1, -1, this.channelCount, this.sampleRateHz, java.util.Collections.singletonList(bArr), null, 0, this.language);
                if (!formatCreateAudioSampleFormat.equals(this.format)) {
                    this.format = formatCreateAudioSampleFormat;
                    this.sampleDurationUs = 1024000000 / formatCreateAudioSampleFormat.sampleRate;
                    this.output.format(formatCreateAudioSampleFormat);
                }
            } else {
                parsableBitArray.skipBits(((int) latmGetValue(parsableBitArray)) - parseAudioSpecificConfig(parsableBitArray));
            }
            parseFrameLength(parsableBitArray);
            this.otherDataPresent = parsableBitArray.readBit();
            this.otherDataLenBits = 0L;
            if (this.otherDataPresent) {
                if (bits == 1) {
                    this.otherDataLenBits = latmGetValue(parsableBitArray);
                } else {
                    do {
                        bit = parsableBitArray.readBit();
                        this.otherDataLenBits = (this.otherDataLenBits << 8) + parsableBitArray.readBits(8);
                    } while (bit);
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(8);
                return;
            }
            return;
        }
        throw new com.google.android.exoplayer2.ParserException();
    }

    private void parseFrameLength(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        this.frameLengthType = parsableBitArray.readBits(3);
        int i_renamed = this.frameLengthType;
        if (i_renamed == 0) {
            parsableBitArray.skipBits(8);
            return;
        }
        if (i_renamed == 1) {
            parsableBitArray.skipBits(9);
            return;
        }
        if (i_renamed == 3 || i_renamed == 4 || i_renamed == 5) {
            parsableBitArray.skipBits(6);
        } else {
            if (i_renamed == 6 || i_renamed == 7) {
                parsableBitArray.skipBits(1);
                return;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    private int parseAudioSpecificConfig(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        int iBitsLeft = parsableBitArray.bitsLeft();
        android.util.Pair<java.lang.Integer, java.lang.Integer> aacAudioSpecificConfig = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(parsableBitArray, true);
        this.sampleRateHz = ((java.lang.Integer) aacAudioSpecificConfig.first).intValue();
        this.channelCount = ((java.lang.Integer) aacAudioSpecificConfig.second).intValue();
        return iBitsLeft - parsableBitArray.bitsLeft();
    }

    private int parsePayloadLengthInfo(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) throws com.google.android.exoplayer2.ParserException {
        int bits;
        if (this.frameLengthType != 0) {
            throw new com.google.android.exoplayer2.ParserException();
        }
        int i_renamed = 0;
        do {
            bits = parsableBitArray.readBits(8);
            i_renamed += bits;
        } while (bits == 255);
        return i_renamed;
    }

    private void parsePayloadMux(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i_renamed) {
        int position = parsableBitArray.getPosition();
        if ((position & 7) == 0) {
            this.sampleDataBuffer.setPosition(position >> 3);
        } else {
            parsableBitArray.readBits(this.sampleDataBuffer.data, 0, i_renamed * 8);
            this.sampleDataBuffer.setPosition(0);
        }
        this.output.sampleData(this.sampleDataBuffer, i_renamed);
        this.output.sampleMetadata(this.timeUs, 1, i_renamed, 0, null);
        this.timeUs += this.sampleDurationUs;
    }

    private void resetBufferForSize(int i_renamed) {
        this.sampleDataBuffer.reset(i_renamed);
        this.sampleBitArray.reset(this.sampleDataBuffer.data);
    }

    private static long latmGetValue(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        return parsableBitArray.readBits((parsableBitArray.readBits(2) + 1) * 8);
    }
}
