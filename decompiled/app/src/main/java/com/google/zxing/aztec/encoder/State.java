package com.google.zxing.aztec.encoder;

/* loaded from: classes.dex */
final class State {
    static final com.google.zxing.aztec.encoder.State INITIAL_STATE = new com.google.zxing.aztec.encoder.State(com.google.zxing.aztec.encoder.Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final com.google.zxing.aztec.encoder.Token token;

    private State(com.google.zxing.aztec.encoder.Token token, int i_renamed, int i2, int i3) {
        this.token = token;
        this.mode = i_renamed;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    int getMode() {
        return this.mode;
    }

    com.google.zxing.aztec.encoder.Token getToken() {
        return this.token;
    }

    int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    int getBitCount() {
        return this.bitCount;
    }

    com.google.zxing.aztec.encoder.State latchAndAppend(int i_renamed, int i2) {
        int i3 = this.bitCount;
        com.google.zxing.aztec.encoder.Token tokenAdd = this.token;
        if (i_renamed != this.mode) {
            int i4 = com.google.zxing.aztec.encoder.HighLevelEncoder.LATCH_TABLE[this.mode][i_renamed];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            tokenAdd = tokenAdd.add(i5, i6);
            i3 += i6;
        }
        int i7 = i_renamed == 2 ? 4 : 5;
        return new com.google.zxing.aztec.encoder.State(tokenAdd.add(i2, i7), i_renamed, 0, i3 + i7);
    }

    com.google.zxing.aztec.encoder.State shiftAndAppend(int i_renamed, int i2) {
        com.google.zxing.aztec.encoder.Token token = this.token;
        int i3 = this.mode == 2 ? 4 : 5;
        return new com.google.zxing.aztec.encoder.State(token.add(com.google.zxing.aztec.encoder.HighLevelEncoder.SHIFT_TABLE[this.mode][i_renamed], i3).add(i2, 5), this.mode, 0, this.bitCount + i3 + 5);
    }

    com.google.zxing.aztec.encoder.State addBinaryShiftChar(int i_renamed) {
        com.google.zxing.aztec.encoder.Token tokenAdd = this.token;
        int i2 = this.mode;
        int i3 = this.bitCount;
        if (i2 == 4 || i2 == 2) {
            int i4 = com.google.zxing.aztec.encoder.HighLevelEncoder.LATCH_TABLE[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            tokenAdd = tokenAdd.add(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.binaryShiftByteCount;
        com.google.zxing.aztec.encoder.State state = new com.google.zxing.aztec.encoder.State(tokenAdd, i2, this.binaryShiftByteCount + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i_renamed + 1) : state;
    }

    com.google.zxing.aztec.encoder.State endBinaryShift(int i_renamed) {
        int i2 = this.binaryShiftByteCount;
        return i2 == 0 ? this : new com.google.zxing.aztec.encoder.State(this.token.addBinaryShift(i_renamed - i2, i2), this.mode, 0, this.bitCount);
    }

    boolean isBetterThanOrEqualTo(com.google.zxing.aztec.encoder.State state) {
        int iCalculateBinaryShiftCost = this.bitCount + (com.google.zxing.aztec.encoder.HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i_renamed = this.binaryShiftByteCount;
        int i2 = state.binaryShiftByteCount;
        if (i_renamed < i2) {
            iCalculateBinaryShiftCost += calculateBinaryShiftCost(state) - calculateBinaryShiftCost(this);
        } else if (i_renamed > i2 && i2 > 0) {
            iCalculateBinaryShiftCost += 10;
        }
        return iCalculateBinaryShiftCost <= state.bitCount;
    }

    com.google.zxing.common.BitArray toBitArray(byte[] bArr) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        for (com.google.zxing.aztec.encoder.Token previous = endBinaryShift(bArr.length).token; previous != null; previous = previous.getPrevious()) {
            linkedList.addFirst(previous);
        }
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray();
        java.util.Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((com.google.zxing.aztec.encoder.Token) it.next()).appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public java.lang.String toString() {
        return java.lang.String.format("%s_renamed bits=%d_renamed bytes=%d_renamed", com.google.zxing.aztec.encoder.HighLevelEncoder.MODE_NAMES[this.mode], java.lang.Integer.valueOf(this.bitCount), java.lang.Integer.valueOf(this.binaryShiftByteCount));
    }

    private static int calculateBinaryShiftCost(com.google.zxing.aztec.encoder.State state) {
        int i_renamed = state.binaryShiftByteCount;
        if (i_renamed > 62) {
            return 21;
        }
        if (i_renamed > 31) {
            return 20;
        }
        return i_renamed > 0 ? 10 : 0;
    }
}
