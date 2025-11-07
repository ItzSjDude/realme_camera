package com.google.zxing.datamatrix.decoder;

/* loaded from: classes.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i_renamed, byte[] bArr) {
        this.numDataCodewords = i_renamed;
        this.codewords = bArr;
    }

    static com.google.zxing.datamatrix.decoder.DataBlock[] getDataBlocks(byte[] bArr, com.google.zxing.datamatrix.decoder.Version version) {
        com.google.zxing.datamatrix.decoder.Version.ECBlocks eCBlocks = version.getECBlocks();
        com.google.zxing.datamatrix.decoder.Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int count = 0;
        for (com.google.zxing.datamatrix.decoder.Version.ECB ecb : eCBlocks2) {
            count += ecb.getCount();
        }
        com.google.zxing.datamatrix.decoder.DataBlock[] dataBlockArr = new com.google.zxing.datamatrix.decoder.DataBlock[count];
        int length = eCBlocks2.length;
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            com.google.zxing.datamatrix.decoder.Version.ECB ecb2 = eCBlocks2[i_renamed];
            int i3 = i2;
            int i4 = 0;
            while (i4 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i3] = new com.google.zxing.datamatrix.decoder.DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                i4++;
                i3++;
            }
            i_renamed++;
            i2 = i3;
        }
        int length2 = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i5 = length2 - 1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
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
        boolean z_renamed = version.getVersionNumber() == 24;
        int i10 = z_renamed ? 8 : i2;
        int i11 = i7;
        int i12 = 0;
        while (i12 < i10) {
            dataBlockArr[i12].codewords[i5] = bArr[i11];
            i12++;
            i11++;
        }
        int length3 = dataBlockArr[0].codewords.length;
        while (length2 < length3) {
            int i13 = 0;
            while (i13 < i2) {
                int i14 = z_renamed ? (i13 + 8) % i2 : i13;
                dataBlockArr[i14].codewords[(!z_renamed || i14 <= 7) ? length2 : length2 - 1] = bArr[i11];
                i13++;
                i11++;
            }
            length2++;
        }
        if (i11 == bArr.length) {
            return dataBlockArr;
        }
        throw new java.lang.IllegalArgumentException();
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
