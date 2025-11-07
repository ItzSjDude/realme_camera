package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class EAN8Reader extends com.google.zxing.oned.UPCEANReader {
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
        while (i2 < 4 && i_renamed < size) {
            sb.append((char) (decodeDigit(bitArray, iArr2, i_renamed, L_PATTERNS) + 48));
            int i3 = i_renamed;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            i2++;
            i_renamed = i3;
        }
        int i5 = findGuardPattern(bitArray, i_renamed, true, MIDDLE_PATTERN)[1];
        int i6 = 0;
        while (i6 < 4 && i5 < size) {
            sb.append((char) (decodeDigit(bitArray, iArr2, i5, L_PATTERNS) + 48));
            int i7 = i5;
            for (int i8 : iArr2) {
                i7 += i8;
            }
            i6++;
            i5 = i7;
        }
        return i5;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    com.google.zxing.BarcodeFormat getBarcodeFormat() {
        return com.google.zxing.BarcodeFormat.EAN_8;
    }
}
