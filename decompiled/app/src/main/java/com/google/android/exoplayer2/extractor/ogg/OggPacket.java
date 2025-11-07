package com.google.android.exoplayer2.extractor.ogg;

/* loaded from: classes.dex */
final class OggPacket {
    private boolean populated;
    private int segmentCount;
    private final com.google.android.exoplayer2.extractor.ogg.OggPageHeader pageHeader = new com.google.android.exoplayer2.extractor.ogg.OggPageHeader();
    private final com.google.android.exoplayer2.util.ParsableByteArray packetArray = new com.google.android.exoplayer2.util.ParsableByteArray(new byte[com.google.android.exoplayer2.extractor.ogg.OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private int currentSegmentIndex = -1;

    OggPacket() {
    }

    public void reset() {
        this.pageHeader.reset();
        this.packetArray.reset();
        this.currentSegmentIndex = -1;
        this.populated = false;
    }

    public boolean populate(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed;
        com.google.android.exoplayer2.util.Assertions.checkState(extractorInput != null);
        if (this.populated) {
            this.populated = false;
            this.packetArray.reset();
        }
        while (!this.populated) {
            if (this.currentSegmentIndex < 0) {
                if (!this.pageHeader.populate(extractorInput, true)) {
                    return false;
                }
                int iCalculatePacketSize = this.pageHeader.headerSize;
                if ((this.pageHeader.type & 1) == 1 && this.packetArray.limit() == 0) {
                    iCalculatePacketSize += calculatePacketSize(0);
                    i_renamed = this.segmentCount + 0;
                } else {
                    i_renamed = 0;
                }
                extractorInput.skipFully(iCalculatePacketSize);
                this.currentSegmentIndex = i_renamed;
            }
            int iCalculatePacketSize2 = calculatePacketSize(this.currentSegmentIndex);
            int i2 = this.currentSegmentIndex + this.segmentCount;
            if (iCalculatePacketSize2 > 0) {
                if (this.packetArray.capacity() < this.packetArray.limit() + iCalculatePacketSize2) {
                    com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.packetArray;
                    parsableByteArray.data = java.util.Arrays.copyOf(parsableByteArray.data, this.packetArray.limit() + iCalculatePacketSize2);
                }
                extractorInput.readFully(this.packetArray.data, this.packetArray.limit(), iCalculatePacketSize2);
                com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = this.packetArray;
                parsableByteArray2.setLimit(parsableByteArray2.limit() + iCalculatePacketSize2);
                this.populated = this.pageHeader.laces[i2 + (-1)] != 255;
            }
            if (i2 == this.pageHeader.pageSegmentCount) {
                i2 = -1;
            }
            this.currentSegmentIndex = i2;
        }
        return true;
    }

    public com.google.android.exoplayer2.extractor.ogg.OggPageHeader getPageHeader() {
        return this.pageHeader;
    }

    public com.google.android.exoplayer2.util.ParsableByteArray getPayload() {
        return this.packetArray;
    }

    public void trimPayload() {
        if (this.packetArray.data.length == 65025) {
            return;
        }
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = this.packetArray;
        parsableByteArray.data = java.util.Arrays.copyOf(parsableByteArray.data, java.lang.Math.max(com.google.android.exoplayer2.extractor.ogg.OggPageHeader.MAX_PAGE_PAYLOAD, this.packetArray.limit()));
    }

    private int calculatePacketSize(int i_renamed) {
        int i2 = 0;
        this.segmentCount = 0;
        while (this.segmentCount + i_renamed < this.pageHeader.pageSegmentCount) {
            int[] iArr = this.pageHeader.laces;
            int i3 = this.segmentCount;
            this.segmentCount = i3 + 1;
            int i4 = iArr[i3 + i_renamed];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
