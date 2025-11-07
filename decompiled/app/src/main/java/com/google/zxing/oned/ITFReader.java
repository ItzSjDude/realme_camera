package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class ITFReader extends com.google.zxing.oned.OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.5f;
    private static final int N_renamed = 1;
    private static final int W_renamed = 3;
    private static final int w_renamed = 2;
    private int narrowLineWidth = -1;
    private static final int[] DEFAULT_ALLOWED_LENGTHS = {6, 8, 10, 12, 14};
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[][] END_PATTERN_REVERSED = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    private static final int[][] PATTERNS = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.OneDReader
    public com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        boolean z_renamed;
        int[] iArrDecodeStart = decodeStart(bitArray);
        int[] iArrDecodeEnd = decodeEnd(bitArray);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        decodeMiddle(bitArray, iArrDecodeStart[1], iArrDecodeEnd[0], sb);
        java.lang.String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(com.google.zxing.DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z_renamed = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z_renamed = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z_renamed && length > i3) {
            z_renamed = true;
        }
        if (!z_renamed) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        float f_renamed = i_renamed;
        return new com.google.zxing.Result(string, null, new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint(iArrDecodeStart[1], f_renamed), new com.google.zxing.ResultPoint(iArrDecodeEnd[0], f_renamed)}, com.google.zxing.BarcodeFormat.ITF);
    }

    private static void decodeMiddle(com.google.zxing.common.BitArray bitArray, int i_renamed, int i2, java.lang.StringBuilder sb) throws com.google.zxing.NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i_renamed < i2) {
            recordPattern(bitArray, i_renamed, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (decodeDigit(iArr2) + 48));
            sb.append((char) (decodeDigit(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i_renamed += iArr[i5];
            }
        }
    }

    private int[] decodeStart(com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        int[] iArrFindGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        this.narrowLineWidth = (iArrFindGuardPattern[1] - iArrFindGuardPattern[0]) / 4;
        validateQuietZone(bitArray, iArrFindGuardPattern[0]);
        return iArrFindGuardPattern;
    }

    private void validateQuietZone(com.google.zxing.common.BitArray bitArray, int i_renamed) throws com.google.zxing.NotFoundException {
        int i2 = this.narrowLineWidth * 10;
        if (i2 >= i_renamed) {
            i2 = i_renamed;
        }
        for (int i3 = i_renamed - 1; i2 > 0 && i3 >= 0 && !bitArray.get(i3); i3--) {
            i2--;
        }
        if (i2 != 0) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
    }

    private static int skipWhiteSpace(com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private int[] decodeEnd(com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        int[] iArrFindGuardPattern;
        bitArray.reverse();
        try {
            int iSkipWhiteSpace = skipWhiteSpace(bitArray);
            try {
                iArrFindGuardPattern = findGuardPattern(bitArray, iSkipWhiteSpace, END_PATTERN_REVERSED[0]);
            } catch (com.google.zxing.NotFoundException unused) {
                iArrFindGuardPattern = findGuardPattern(bitArray, iSkipWhiteSpace, END_PATTERN_REVERSED[1]);
            }
            validateQuietZone(bitArray, iArrFindGuardPattern[0]);
            int i_renamed = iArrFindGuardPattern[0];
            iArrFindGuardPattern[0] = bitArray.getSize() - iArrFindGuardPattern[1];
            iArrFindGuardPattern[1] = bitArray.getSize() - i_renamed;
            return iArrFindGuardPattern;
        } finally {
            bitArray.reverse();
        }
    }

    private static int[] findGuardPattern(com.google.zxing.common.BitArray bitArray, int i_renamed, int[] iArr) throws com.google.zxing.NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i2 = i_renamed;
        boolean z_renamed = false;
        int i3 = 0;
        while (i_renamed < size) {
            if (bitArray.get(i_renamed) != z_renamed) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < 0.38f) {
                        return new int[]{i2, i_renamed};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    java.lang.System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z_renamed = !z_renamed;
            }
            i_renamed++;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static int decodeDigit(int[] iArr) throws com.google.zxing.NotFoundException {
        int length = PATTERNS.length;
        float f_renamed = 0.38f;
        int i_renamed = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fPatternMatchVariance = patternMatchVariance(iArr, PATTERNS[i2], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f_renamed) {
                i_renamed = i2;
                f_renamed = fPatternMatchVariance;
            } else if (fPatternMatchVariance == f_renamed) {
                i_renamed = -1;
            }
        }
        if (i_renamed >= 0) {
            return i_renamed % 10;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }
}
