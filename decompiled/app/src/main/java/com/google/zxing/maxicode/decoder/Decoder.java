package com.google.zxing.maxicode.decoder;

/* loaded from: classes.dex */
public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final com.google.zxing.common.reedsolomon.ReedSolomonDecoder rsDecoder = new com.google.zxing.common.reedsolomon.ReedSolomonDecoder(com.google.zxing.common.reedsolomon.GenericGF.MAXICODE_FIELD_64);

    public com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(bitMatrix, null);
    }

    public com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix bitMatrix, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        byte[] bArr;
        byte[] codewords = new com.google.zxing.maxicode.decoder.BitMatrixParser(bitMatrix).readCodewords();
        correctErrors(codewords, 0, 10, 10, 0);
        int i_renamed = codewords[0] & 15;
        if (i_renamed == 2 || i_renamed == 3 || i_renamed == 4) {
            correctErrors(codewords, 20, 84, 40, 1);
            correctErrors(codewords, 20, 84, 40, 2);
            bArr = new byte[94];
        } else if (i_renamed == 5) {
            correctErrors(codewords, 20, 68, 56, 1);
            correctErrors(codewords, 20, 68, 56, 2);
            bArr = new byte[78];
        } else {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        java.lang.System.arraycopy(codewords, 0, bArr, 0, 10);
        java.lang.System.arraycopy(codewords, 20, bArr, 10, bArr.length - 10);
        return com.google.zxing.maxicode.decoder.DecodedBitStreamParser.decode(bArr, i_renamed);
    }

    private void correctErrors(byte[] bArr, int i_renamed, int i2, int i3, int i4) throws com.google.zxing.ChecksumException {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i_renamed] & 255;
            }
        }
        try {
            this.rsDecoder.decode(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i_renamed] = (byte) iArr[i8 / i6];
                }
            }
        } catch (com.google.zxing.common.reedsolomon.ReedSolomonException unused) {
            throw com.google.zxing.ChecksumException.getChecksumInstance();
        }
    }
}
