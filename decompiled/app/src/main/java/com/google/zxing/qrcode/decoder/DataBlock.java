package com.google.zxing.qrcode.decoder;

/* loaded from: classes.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i_renamed, byte[] bArr) {
        this.numDataCodewords = i_renamed;
        this.codewords = bArr;
    }

    static com.google.zxing.qrcode.decoder.DataBlock[] getDataBlocks(byte[] bArr, com.google.zxing.qrcode.decoder.Version version, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new java.lang.IllegalArgumentException();
        }
        com.google.zxing.qrcode.decoder.Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        com.google.zxing.qrcode.decoder.Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int count = 0;
        for (com.google.zxing.qrcode.decoder.Version.ECB ecb : eCBlocks) {
            count += ecb.getCount();
        }
        com.google.zxing.qrcode.decoder.DataBlock[] dataBlockArr = new com.google.zxing.qrcode.decoder.DataBlock[count];
        int length = eCBlocks.length;
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            com.google.zxing.qrcode.decoder.Version.ECB ecb2 = eCBlocks[i_renamed];
            int i3 = i2;
            int i4 = 0;
            while (i4 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i3] = new com.google.zxing.qrcode.decoder.DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i4++;
                i3++;
            }
            i_renamed++;
            i2 = i3;
        }
        int length2 = dataBlockArr[0].codewords.length;
        int length3 = dataBlockArr.length - 1;
        while (length3 >= 0 && dataBlockArr[length3].codewords.length != length2) {
            length3--;
        }
        int i5 = length3 + 1;
        int eCCodewordsPerBlock = length2 - eCBlocksForLevel.getECCodewordsPerBlock();
        int i6 = 0;
        int i7 = 0;
        while (i6 < eCCodewordsPerBlock) {
            int i8 = i7;
            int i9 = 0;
            while (i9 < i2) {
                dataBlockArr[i9].codewords[i6] = bArr[i8];
                i9++;
                i8++;
            }
            i6++;
            i7 = i8;
        }
        int i10 = i5;
        while (i10 < i2) {
            dataBlockArr[i10].codewords[eCCodewordsPerBlock] = bArr[i7];
            i10++;
            i7++;
        }
        int length4 = dataBlockArr[0].codewords.length;
        while (eCCodewordsPerBlock < length4) {
            int i11 = i7;
            int i12 = 0;
            while (i12 < i2) {
                dataBlockArr[i12].codewords[i12 < i5 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i11];
                i12++;
                i11++;
            }
            eCCodewordsPerBlock++;
            i7 = i11;
        }
        return dataBlockArr;
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
