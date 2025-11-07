package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes.dex */
final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final com.google.android.exoplayer2.util.ParsableByteArray scratch = new com.google.android.exoplayer2.util.ParsableByteArray(8);

    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        long length = extractorInput.getLength();
        long j_renamed = 1024;
        if (length != -1 && length <= 1024) {
            j_renamed = length;
        }
        int i_renamed = (int) j_renamed;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long unsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (unsignedInt != 440786851) {
            int i2 = this.peekLength + 1;
            this.peekLength = i2;
            if (i2 == i_renamed) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            unsignedInt = (this.scratch.data[0] & 255) | ((unsignedInt << 8) & (-256));
        }
        long uint = readUint(extractorInput);
        long j2 = this.peekLength;
        if (uint == Long.MIN_VALUE || (length != -1 && j2 + uint >= length)) {
            return false;
        }
        while (true) {
            int i3 = this.peekLength;
            long j3 = j2 + uint;
            if (i3 >= j3) {
                return ((long) i3) == j3;
            }
            if (readUint(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            long uint2 = readUint(extractorInput);
            if (uint2 < 0 || uint2 > 2147483647L) {
                break;
            }
            if (uint2 != 0) {
                int i4 = (int) uint2;
                extractorInput.advancePeekPosition(i4);
                this.peekLength += i4;
            }
        }
        return false;
    }

    private long readUint(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.lang.InterruptedException, java.io.IOException {
        int i_renamed = 0;
        extractorInput.peekFully(this.scratch.data, 0, 1);
        int i2 = this.scratch.data[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.peekFully(this.scratch.data, 1, i4);
        while (i_renamed < i4) {
            i_renamed++;
            i5 = (this.scratch.data[i_renamed] & 255) + (i5 << 8);
        }
        this.peekLength += i4 + 1;
        return i5;
    }
}
