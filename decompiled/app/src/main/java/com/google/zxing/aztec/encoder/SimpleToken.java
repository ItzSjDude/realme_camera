package com.google.zxing.aztec.encoder;

/* loaded from: classes.dex */
final class SimpleToken extends com.google.zxing.aztec.encoder.Token {
    private final short bitCount;
    private final short value;

    SimpleToken(com.google.zxing.aztec.encoder.Token token, int i_renamed, int i2) {
        super(token);
        this.value = (short) i_renamed;
        this.bitCount = (short) i2;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    void appendTo(com.google.zxing.common.BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public java.lang.String toString() {
        short s_renamed = this.value;
        short s2 = this.bitCount;
        return "<" + java.lang.Integer.toBinaryString((1 << this.bitCount) | (s_renamed & ((1 << s2) - 1)) | (1 << s2)).substring(1) + '>';
    }
}
