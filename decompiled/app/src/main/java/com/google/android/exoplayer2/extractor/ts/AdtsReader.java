package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class AdtsReader implements com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER = {73, 68, 51};
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 512;
    private static final int MATCH_STATE_I = 768;
    private static final int MATCH_STATE_ID = 1024;
    private static final int MATCH_STATE_START = 256;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_CHECKING_ADTS_HEADER = 1;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 3;
    private static final int STATE_READING_ID3_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 4;
    private static final java.lang.String TAG = "AdtsReader";
    private static final int VERSION_UNSET = -1;
    private final com.google.android.exoplayer2.util.ParsableBitArray adtsScratch;
    private int bytesRead;
    private int currentFrameVersion;
    private com.google.android.exoplayer2.extractor.TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private int firstFrameSampleRateIndex;
    private int firstFrameVersion;
    private java.lang.String formatId;
    private boolean foundFirstFrame;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final com.google.android.exoplayer2.util.ParsableByteArray id3HeaderBuffer;
    private com.google.android.exoplayer2.extractor.TrackOutput id3Output;
    private final java.lang.String language;
    private int matchState;
    private com.google.android.exoplayer2.extractor.TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public static boolean isAdtsSyncWord(int i_renamed) {
        return (i_renamed & 65526) == 65520;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public AdtsReader(boolean z_renamed) {
        this(z_renamed, null);
    }

    public AdtsReader(boolean z_renamed, java.lang.String str) {
        this.adtsScratch = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new com.google.android.exoplayer2.util.ParsableByteArray(java.util.Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.firstFrameVersion = -1;
        this.firstFrameSampleRateIndex = -1;
        this.sampleDurationUs = -9223372036854775807L;
        this.exposeId3 = z_renamed;
        this.language = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        resetSync();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        if (this.exposeId3) {
            trackIdGenerator.generateNewId();
            this.id3Output = extractorOutput.track(trackIdGenerator.getTrackId(), 4);
            this.id3Output.format(com.google.android.exoplayer2.Format.createSampleFormat(trackIdGenerator.getFormatId(), com.google.android.exoplayer2.util.MimeTypes.APPLICATION_ID3, null, -1, null));
            return;
        }
        this.id3Output = new com.google.android.exoplayer2.extractor.DummyTrackOutput();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j_renamed, int i_renamed) {
        this.timeUs = j_renamed;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.ParserException {
        while (parsableByteArray.bytesLeft() > 0) {
            int i_renamed = this.state;
            if (i_renamed == 0) {
                findNextSample(parsableByteArray);
            } else if (i_renamed == 1) {
                checkAdtsHeader(parsableByteArray);
            } else if (i_renamed != 2) {
                if (i_renamed == 3) {
                    if (continueRead(parsableByteArray, this.adtsScratch.data, this.hasCrc ? 7 : 5)) {
                        parseAdtsHeader();
                    }
                } else if (i_renamed == 4) {
                    readSample(parsableByteArray);
                } else {
                    throw new java.lang.IllegalStateException();
                }
            } else if (continueRead(parsableByteArray, this.id3HeaderBuffer.data, 10)) {
                parseId3Header();
            }
        }
    }

    public long getSampleDurationUs() {
        return this.sampleDurationUs;
    }

    private void resetSync() {
        this.foundFirstFrame = false;
        setFindingSampleState();
    }

    private boolean continueRead(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i_renamed) {
        int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), i_renamed - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, iMin);
        this.bytesRead += iMin;
        return this.bytesRead == i_renamed;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingId3HeaderState() {
        this.state = 2;
        this.bytesRead = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(com.google.android.exoplayer2.extractor.TrackOutput trackOutput, long j_renamed, int i_renamed, int i2) {
        this.state = 4;
        this.bytesRead = i_renamed;
        this.currentOutput = trackOutput;
        this.currentSampleDuration = j_renamed;
        this.sampleSize = i2;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 3;
        this.bytesRead = 0;
    }

    private void setCheckingAdtsHeaderState() {
        this.state = 1;
        this.bytesRead = 0;
    }

    private void findNextSample(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit) {
            int i_renamed = position + 1;
            int i2 = bArr[position] & 255;
            if (this.matchState == 512 && isAdtsSyncBytes((byte) -1, (byte) i2) && (this.foundFirstFrame || checkSyncPositionValid(parsableByteArray, i_renamed - 2))) {
                this.currentFrameVersion = (i2 & 8) >> 3;
                this.hasCrc = (i2 & 1) == 0;
                if (!this.foundFirstFrame) {
                    setCheckingAdtsHeaderState();
                } else {
                    setReadingAdtsHeaderState();
                }
                parsableByteArray.setPosition(i_renamed);
                return;
            }
            int i3 = this.matchState;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.matchState = MATCH_STATE_I;
            } else if (i4 == 511) {
                this.matchState = 512;
            } else if (i4 == 836) {
                this.matchState = 1024;
            } else if (i4 == 1075) {
                setReadingId3HeaderState();
                parsableByteArray.setPosition(i_renamed);
                return;
            } else if (i3 != 256) {
                this.matchState = 256;
                i_renamed--;
            }
            position = i_renamed;
        }
        parsableByteArray.setPosition(position);
    }

    private void checkAdtsHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() == 0) {
            return;
        }
        this.adtsScratch.data[0] = parsableByteArray.data[parsableByteArray.getPosition()];
        this.adtsScratch.setPosition(2);
        int bits = this.adtsScratch.readBits(4);
        int i_renamed = this.firstFrameSampleRateIndex;
        if (i_renamed != -1 && bits != i_renamed) {
            resetSync();
            return;
        }
        if (!this.foundFirstFrame) {
            this.foundFirstFrame = true;
            this.firstFrameVersion = this.currentFrameVersion;
            this.firstFrameSampleRateIndex = bits;
        }
        setReadingAdtsHeaderState();
    }

    private boolean checkSyncPositionValid(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        parsableByteArray.setPosition(i_renamed + 1);
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
            return false;
        }
        this.adtsScratch.setPosition(4);
        int bits = this.adtsScratch.readBits(1);
        int i2 = this.firstFrameVersion;
        if (i2 != -1 && bits != i2) {
            return false;
        }
        if (this.firstFrameSampleRateIndex != -1) {
            if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
                return true;
            }
            this.adtsScratch.setPosition(2);
            if (this.adtsScratch.readBits(4) != this.firstFrameSampleRateIndex) {
                return false;
            }
            parsableByteArray.setPosition(i_renamed + 2);
        }
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 4)) {
            return true;
        }
        this.adtsScratch.setPosition(14);
        int bits2 = this.adtsScratch.readBits(13);
        if (bits2 <= 6) {
            return false;
        }
        int i3 = i_renamed + bits2;
        int i4 = i3 + 1;
        if (i4 >= parsableByteArray.limit()) {
            return true;
        }
        return isAdtsSyncBytes(parsableByteArray.data[i3], parsableByteArray.data[i4]) && (this.firstFrameVersion == -1 || ((parsableByteArray.data[i4] & 8) >> 3) == bits);
    }

    private boolean isAdtsSyncBytes(byte b2, byte b3) {
        return isAdtsSyncWord(((b2 & 255) << 8) | (b3 & 255));
    }

    private boolean tryRead(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i_renamed) {
        if (parsableByteArray.bytesLeft() < i_renamed) {
            return false;
        }
        parsableByteArray.readBytes(bArr, 0, i_renamed);
        return true;
    }

    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        setReadingSampleState(this.id3Output, 0L, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    private void parseAdtsHeader() throws com.google.android.exoplayer2.ParserException {
        this.adtsScratch.setPosition(0);
        if (!this.hasOutputFormat) {
            int bits = this.adtsScratch.readBits(2) + 1;
            if (bits != 2) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Detected audio object type: " + bits + ", but assuming AAC LC.");
                bits = 2;
            }
            this.adtsScratch.skipBits(5);
            byte[] bArrBuildAacAudioSpecificConfig = com.google.android.exoplayer2.util.CodecSpecificDataUtil.buildAacAudioSpecificConfig(bits, this.firstFrameSampleRateIndex, this.adtsScratch.readBits(3));
            android.util.Pair<java.lang.Integer, java.lang.Integer> aacAudioSpecificConfig = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArrBuildAacAudioSpecificConfig);
            com.google.android.exoplayer2.Format formatCreateAudioSampleFormat = com.google.android.exoplayer2.Format.createAudioSampleFormat(this.formatId, com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC, null, -1, -1, ((java.lang.Integer) aacAudioSpecificConfig.second).intValue(), ((java.lang.Integer) aacAudioSpecificConfig.first).intValue(), java.util.Collections.singletonList(bArrBuildAacAudioSpecificConfig), null, 0, this.language);
            this.sampleDurationUs = 1024000000 / formatCreateAudioSampleFormat.sampleRate;
            this.output.format(formatCreateAudioSampleFormat);
            this.hasOutputFormat = true;
        } else {
            this.adtsScratch.skipBits(10);
        }
        this.adtsScratch.skipBits(4);
        int bits2 = (this.adtsScratch.readBits(13) - 2) - 5;
        if (this.hasCrc) {
            bits2 -= 2;
        }
        setReadingSampleState(this.output, this.sampleDurationUs, 0, bits2);
    }

    private void readSample(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(parsableByteArray, iMin);
        this.bytesRead += iMin;
        int i_renamed = this.bytesRead;
        int i2 = this.sampleSize;
        if (i_renamed == i2) {
            this.currentOutput.sampleMetadata(this.timeUs, 1, i2, 0, null);
            this.timeUs += this.currentSampleDuration;
            setFindingSampleState();
        }
    }
}
