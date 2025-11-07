package com.google.android.exoplayer2.extractor.ts;

/* loaded from: classes.dex */
public final class SectionReader implements com.google.android.exoplayer2.extractor.ts.TsPayloadReader {
    private static final int DEFAULT_SECTION_BUFFER_LENGTH = 32;
    private static final int MAX_SECTION_LENGTH = 4098;
    private static final int SECTION_HEADER_LENGTH = 3;
    private int bytesRead;
    private final com.google.android.exoplayer2.extractor.ts.SectionPayloadReader reader;
    private final com.google.android.exoplayer2.util.ParsableByteArray sectionData = new com.google.android.exoplayer2.util.ParsableByteArray(32);
    private boolean sectionSyntaxIndicator;
    private int totalSectionLength;
    private boolean waitingForPayloadStart;

    public SectionReader(com.google.android.exoplayer2.extractor.ts.SectionPayloadReader sectionPayloadReader) {
        this.reader = sectionPayloadReader;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster, com.google.android.exoplayer2.extractor.ExtractorOutput extractorOutput, com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.reader.init(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.waitingForPayloadStart = true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void seek() {
        this.waitingForPayloadStart = true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void consume(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        boolean z_renamed = (i_renamed & 1) != 0;
        int unsignedByte = z_renamed ? parsableByteArray.readUnsignedByte() + parsableByteArray.getPosition() : -1;
        if (this.waitingForPayloadStart) {
            if (!z_renamed) {
                return;
            }
            this.waitingForPayloadStart = false;
            parsableByteArray.setPosition(unsignedByte);
            this.bytesRead = 0;
        }
        while (parsableByteArray.bytesLeft() > 0) {
            int i2 = this.bytesRead;
            if (i2 < 3) {
                if (i2 == 0) {
                    int unsignedByte2 = parsableByteArray.readUnsignedByte();
                    parsableByteArray.setPosition(parsableByteArray.getPosition() - 1);
                    if (unsignedByte2 == 255) {
                        this.waitingForPayloadStart = true;
                        return;
                    }
                }
                int iMin = java.lang.Math.min(parsableByteArray.bytesLeft(), 3 - this.bytesRead);
                parsableByteArray.readBytes(this.sectionData.data, this.bytesRead, iMin);
                this.bytesRead += iMin;
                if (this.bytesRead == 3) {
                    this.sectionData.reset(3);
                    this.sectionData.skipBytes(1);
                    int unsignedByte3 = this.sectionData.readUnsignedByte();
                    int unsignedByte4 = this.sectionData.readUnsignedByte();
                    this.sectionSyntaxIndicator = (unsignedByte3 & 128) != 0;
                    this.totalSectionLength = (((unsignedByte3 & 15) << 8) | unsignedByte4) + 3;
                    if (this.sectionData.capacity() < this.totalSectionLength) {
                        byte[] bArr = this.sectionData.data;
                        this.sectionData.reset(java.lang.Math.min(4098, java.lang.Math.max(this.totalSectionLength, bArr.length * 2)));
                        java.lang.System.arraycopy(bArr, 0, this.sectionData.data, 0, 3);
                    }
                }
            } else {
                int iMin2 = java.lang.Math.min(parsableByteArray.bytesLeft(), this.totalSectionLength - this.bytesRead);
                parsableByteArray.readBytes(this.sectionData.data, this.bytesRead, iMin2);
                this.bytesRead += iMin2;
                int i3 = this.bytesRead;
                int i4 = this.totalSectionLength;
                if (i3 != i4) {
                    continue;
                } else {
                    if (this.sectionSyntaxIndicator) {
                        if (com.google.android.exoplayer2.util.Util.crc(this.sectionData.data, 0, this.totalSectionLength, -1) != 0) {
                            this.waitingForPayloadStart = true;
                            return;
                        }
                        this.sectionData.reset(this.totalSectionLength - 4);
                    } else {
                        this.sectionData.reset(i4);
                    }
                    this.reader.consume(this.sectionData);
                    this.bytesRead = 0;
                }
            }
        }
    }
}
