package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class EAN13Reader extends com.google.zxing.oned.UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    @Override // com.google.zxing.oned.UPCEANReader
    protected int decodeMiddle(com.google.zxing.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.google.zxing.NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i_renamed = iArr[1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 6 && i_renamed < size) {
            int iDecodeDigit = decodeDigit(bitArray, iArr2, i_renamed, L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            int i4 = i_renamed;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (iDecodeDigit >= 10) {
                i3 = (1 << (5 - i2)) | i3;
            }
            i2++;
            i_renamed = i4;
        }
        determineFirstDigit(sb, i3);
        int i6 = findGuardPattern(bitArray, i_renamed, true, MIDDLE_PATTERN)[1];
        int i7 = 0;
        while (i7 < 6 && i6 < size) {
            sb.append((char) (decodeDigit(bitArray, iArr2, i6, L_PATTERNS) + 48));
            int i8 = i6;
            for (int i9 : iArr2) {
                i8 += i9;
            }
            i7++;
            i6 = i8;
        }
        return i6;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    com.google.zxing.BarcodeFormat getBarcodeFormat() {
        return com.google.zxing.BarcodeFormat.EAN_13;
    }

    private static void determineFirstDigit(java.lang.StringBuilder sb, int i_renamed) throws com.google.zxing.NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i_renamed == FIRST_DIGIT_ENCODINGS[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }
}
