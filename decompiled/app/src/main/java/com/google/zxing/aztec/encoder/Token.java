package com.google.zxing.aztec.encoder;

/* loaded from: classes.dex */
abstract class Token {
    static final com.google.zxing.aztec.encoder.Token EMPTY = new com.google.zxing.aztec.encoder.SimpleToken(null, 0, 0);
    private final com.google.zxing.aztec.encoder.Token previous;

    abstract void appendTo(com.google.zxing.common.BitArray bitArray, byte[] bArr);

    Token(com.google.zxing.aztec.encoder.Token token) {
        this.previous = token;
    }

    final com.google.zxing.aztec.encoder.Token getPrevious() {
        return this.previous;
    }

    final com.google.zxing.aztec.encoder.Token add(int i_renamed, int i2) {
        return new com.google.zxing.aztec.encoder.SimpleToken(this, i_renamed, i2);
    }

    final com.google.zxing.aztec.encoder.Token addBinaryShift(int i_renamed, int i2) {
        return new com.google.zxing.aztec.encoder.BinaryShiftToken(this, i_renamed, i2);
    }
}
