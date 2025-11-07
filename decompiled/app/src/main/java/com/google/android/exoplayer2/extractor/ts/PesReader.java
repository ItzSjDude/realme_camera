package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class PesReader implements com.google.android.exoplayer2.extractor.ts.TsPayloadReader {
    private static final int HEADER_SIZE = 9;
    private static final int MAX_HEADER_EXTENSION_SIZE = 10;
    private static final int PES_SCRATCH_SIZE = 10;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_BODY = 3;
    private static final int STATE_READING_HEADER = 1;
    private static final int STATE_READING_HEADER_EXTENSION = 2;
    private static final java.lang.String TAG = "PesReader";
    private int bytesRead;
    private boolean dataAlignmentIndicator;
    private boolean dtsFlag;
    private int extendedHeaderLength;
    private int payloadSize;
    private boolean ptsFlag;
    private final com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader reader;
    private boolean seenFirstDts;
    private long timeUs;
    private com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster;
    private final com.google.android.exoplayer2.util.ParsableBitArray pesScratch = new com.google.android.exoplayer2.util.ParsableBitArray(new byte[10]);
    private int state = 0;

    public PesReader(com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader elementaryStreamReader) {
        this.reader = elementaryStreamReader;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.timestampAdjuster = timestampAdjuster;
        this.reader.createTracks(extractorOutput, trackIdGenerator);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void seek() {
        this.state = 0;
        this.bytesRead = 0;
        this.seenFirstDts = false;
        this.reader.seek();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public final void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) throws com.google.android.exoplayer2.ParserException {
        if ((i_renamed & 1) != 0) {
            int i2 = this.state;
            if (i2 != 0 && i2 != 1) {
                if (i2 == 2) {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unexpected start indicator reading extended header");
                } else if (i2 == 3) {
                    if (this.payloadSize != -1) {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unexpected start indicator: expected " + this.payloadSize + " more bytes");
                    }
                    this.reader.packetFinished();
                } else {
                    throw new java.lang.IllegalStateException();
                }
            }
            setState(1);
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i3 = this.state;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (continueRead(parsableByteArray, this.pesScratch.data, java.lang.Math.min(10, this.extendedHeaderLength)) && continueRead(parsableByteArray, null, this.extendedHeaderLength)) {
                            parseHeaderExtension();
                            i_renamed |= this.dataAlignmentIndicator ? 4 : 0;
                            this.reader.packetStarted(this.timeUs, i_renamed);
                            setState(3);
                        }
                    } else if (i3 == 3) {
                        int iBytesLeft = parsableByteArray.bytesLeft();
                        int i4 = this.payloadSize;
                        int i5 = i4 != -1 ? iBytesLeft - i4 : 0;
                        if (i5 > 0) {
                            iBytesLeft -= i5;
                            parsableByteArray.setLimit(parsableByteArray.getPosition() + iBytesLeft);
                        }
                        this.reader.consume(parsableByteArray);
                        int i6 = this.payloadSize;
                        if (i6 != -1) {
                            this.payloadSize = i6 - iBytesLeft;
                            if (this.payloadSize == 0) {
                                this.reader.packetFinished();
                                setState(1);
                            }
                        }
                    } else {
                        throw new java.lang.IllegalStateException();
                    }
                } else if (continueRead(parsableByteArray, this.pesScratch.data, 9)) {
                    setState(parseHeader() ? 2 : 0);
                }
            } else {
                parsableByteArray.skipBytes(parsableByteArray.bytesLeft());
            }
        }
    }

    private void setState(int i_renamed) {
        this.state = i_renamed;
        this.bytesRead = 0;
    }

    private boolean continueRead(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, byte[] bArr, int i_renamed) {
        int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), i_renamed - this.bytesRead);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.skipBytes(iMin);
        } else {
            parsableByteArray.readBytes(bArr, this.bytesRead, iMin);
        }
        this.bytesRead += iMin;
        return this.bytesRead == i_renamed;
    }

    private boolean parseHeader() {
        this.pesScratch.setPosition(0);
        int bits = this.pesScratch.readBits(24);
        if (bits != 1) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unexpected start code prefix: " + bits);
            this.payloadSize = -1;
            return false;
        }
        this.pesScratch.skipBits(8);
        int bits2 = this.pesScratch.readBits(16);
        this.pesScratch.skipBits(5);
        this.dataAlignmentIndicator = this.pesScratch.readBit();
        this.pesScratch.skipBits(2);
        this.ptsFlag = this.pesScratch.readBit();
        this.dtsFlag = this.pesScratch.readBit();
        this.pesScratch.skipBits(6);
        this.extendedHeaderLength = this.pesScratch.readBits(8);
        if (bits2 == 0) {
            this.payloadSize = -1;
        } else {
            this.payloadSize = ((bits2 + 6) - 9) - this.extendedHeaderLength;
        }
        return true;
    }

    private void parseHeaderExtension() {
        this.pesScratch.setPosition(0);
        this.timeUs = -9223372036854775807L;
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
