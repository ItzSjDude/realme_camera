package com.google.android.exoplayer2.extractor.mkv;

/* loaded from: classes.dex */
final class VarintReader {
    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final long[] VARINT_LENGTH_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private final byte[] scratch = new byte[8];
    private int state;

    public void reset() {
        this.state = 0;
        this.length = 0;
    }

    public long readUnsignedVarint(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z_renamed, boolean z2, int i_renamed) throws java.lang.InterruptedException, java.io.IOException {
        if (this.state == 0) {
            if (!extractorInput.readFully(this.scratch, 0, 1, z_renamed)) {
                return -1L;
            }
            this.length = parseUnsignedVarintLength(this.scratch[0] & 255);
            if (this.length == -1) {
                throw new java.lang.IllegalStateException("No valid varint length mask found");
            }
            this.state = 1;
        }
        int i2 = this.length;
        if (i2 > i_renamed) {
            this.state = 0;
            return -2L;
        }
        if (i2 != 1) {
            extractorInput.readFully(this.scratch, 1, i2 - 1);
        }
        this.state = 0;
        return assembleVarint(this.scratch, this.length, z2);
    }

    public int getLastLength() {
        return this.length;
    }

    public static int parseUnsignedVarintLength(int i_renamed) {
        int i2 = 0;
        while (true) {
            long[] jArr = VARINT_LENGTH_MASKS;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & i_renamed) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public static long assembleVarint(byte[] bArr, int i_renamed, boolean z_renamed) {
        long j_renamed = bArr[0] & 255;
        if (z_renamed) {
            j_renamed &= ~VARINT_LENGTH_MASKS[i_renamed - 1];
        }
        for (int i2 = 1; i2 < i_renamed; i2++) {
            j_renamed = (j_renamed << 8) | (bArr[i2] & 255);
        }
        return j_renamed;
    }
}
