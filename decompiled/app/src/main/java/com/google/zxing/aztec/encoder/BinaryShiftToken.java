package com.google.zxing.aztec.encoder;

/* loaded from: classes.dex */
final class BinaryShiftToken extends com.google.zxing.aztec.encoder.Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    BinaryShiftToken(com.google.zxing.aztec.encoder.Token token, int i_renamed, int i2) {
        super(token);
        this.binaryShiftStart = (short) i_renamed;
        this.binaryShiftByteCount = (short) i2;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(com.google.zxing.common.BitArray bitArray, byte[] bArr) {
        int i_renamed = 0;
        while (true) {
            short s_renamed = this.binaryShiftByteCount;
            if (i_renamed >= s_renamed) {
                return;
            }
            if (i_renamed == 0 || (i_renamed == 31 && s_renamed <= 62)) {
                bitArray.appendBits(31, 5);
                short s2 = this.binaryShiftByteCount;
                if (s2 > 62) {
                    bitArray.appendBits(s2 - 31, 16);
                } else if (i_renamed == 0) {
                    bitArray.appendBits(java.lang.Math.min((int) s2, 31), 5);
                } else {
                    bitArray.appendBits(s2 - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + i_renamed], 8);
            i_renamed++;
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("<");
        sb.append((int) this.binaryShiftStart);
        sb.append("::");
        sb.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        sb.append('>');
        return sb.toString();
    }
}
