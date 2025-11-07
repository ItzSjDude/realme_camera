package com.google.zxing.datamatrix.decoder;

/* loaded from: classes.dex */
public final class Decoder {
    private final com.google.zxing.common.reedsolomon.ReedSolomonDecoder rsDecoder = new com.google.zxing.common.reedsolomon.ReedSolomonDecoder(com.google.zxing.common.reedsolomon.GenericGF.DATA_MATRIX_FIELD_256);

    public com.google.zxing.common.DecoderResult decode(boolean[][] zArr) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(com.google.zxing.common.BitMatrix.parse(zArr));
    }

    public com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.datamatrix.decoder.BitMatrixParser bitMatrixParser = new com.google.zxing.datamatrix.decoder.BitMatrixParser(bitMatrix);
        com.google.zxing.datamatrix.decoder.DataBlock[] dataBlocks = com.google.zxing.datamatrix.decoder.DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), bitMatrixParser.getVersion());
        int numDataCodewords = 0;
        for (com.google.zxing.datamatrix.decoder.DataBlock dataBlock : dataBlocks) {
            numDataCodewords += dataBlock.getNumDataCodewords();
        }
        byte[] bArr = new byte[numDataCodewords];
        int length = dataBlocks.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            com.google.zxing.datamatrix.decoder.DataBlock dataBlock2 = dataBlocks[i_renamed];
            byte[] codewords = dataBlock2.getCodewords();
            int numDataCodewords2 = dataBlock2.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords2);
            for (int i2 = 0; i2 < numDataCodewords2; i2++) {
                bArr[(i2 * length) + i_renamed] = codewords[i2];
            }
        }
        return com.google.zxing.datamatrix.decoder.DecodedBitStreamParser.decode(bArr);
    }

    private void correctErrors(byte[] bArr, int i_renamed) throws com.google.zxing.ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.rsDecoder.decode(iArr, bArr.length - i_renamed);
            for (int i3 = 0; i3 < i_renamed; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.google.zxing.common.reedsolomon.ReedSolomonException unused) {
            throw com.google.zxing.ChecksumException.getChecksumInstance();
        }
    }
}
