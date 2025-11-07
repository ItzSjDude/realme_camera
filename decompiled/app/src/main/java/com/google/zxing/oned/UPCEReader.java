package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class UPCEReader extends com.google.zxing.oned.UPCEANReader {
    private static final int[] MIDDLE_END_PATTERN = {1, 1, 1, 1, 1, 1};
    static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
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
        determineNumSysAndCheckDigit(sb, i3);
        return i_renamed;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected int[] decodeEnd(com.google.zxing.common.BitArray bitArray, int i_renamed) throws com.google.zxing.NotFoundException {
        return findGuardPattern(bitArray, i_renamed, true, MIDDLE_END_PATTERN);
    }

    @Override // com.google.zxing.oned.UPCEANReader
    protected boolean checkChecksum(java.lang.String str) throws com.google.zxing.FormatException {
        return super.checkChecksum(convertUPCEtoUPCA(str));
    }

    private static void determineNumSysAndCheckDigit(java.lang.StringBuilder sb, int i_renamed) throws com.google.zxing.NotFoundException {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i_renamed == NUMSYS_AND_CHECK_DIGIT_PATTERNS[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    com.google.zxing.BarcodeFormat getBarcodeFormat() {
        return com.google.zxing.BarcodeFormat.UPC_E;
    }

    public static java.lang.String convertUPCEtoUPCA(java.lang.String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }
}
