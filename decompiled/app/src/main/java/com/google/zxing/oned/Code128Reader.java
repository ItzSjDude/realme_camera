package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class Code128Reader extends com.google.zxing.oned.OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        boolean z_renamed = false;
        int i_renamed = 0;
        int i2 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z_renamed) {
                iArr[i_renamed] = iArr[i_renamed] + 1;
            } else {
                if (i_renamed == 5) {
                    float f_renamed = MAX_AVG_VARIANCE;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float fPatternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], MAX_INDIVIDUAL_VARIANCE);
                        if (fPatternMatchVariance < f_renamed) {
                            i3 = i4;
                            f_renamed = fPatternMatchVariance;
                        }
                    }
                    if (i3 >= 0 && bitArray.isRange(java.lang.Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                        return new int[]{i2, nextSet, i3};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = i_renamed - 1;
                    java.lang.System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i_renamed] = 0;
                    i_renamed--;
                } else {
                    i_renamed++;
                }
                iArr[i_renamed] = 1;
                z_renamed = !z_renamed;
            }
            nextSet++;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(com.google.zxing.common.BitArray bitArray, int[] iArr, int i_renamed) throws com.google.zxing.NotFoundException {
        recordPattern(bitArray, i_renamed, iArr);
        float f_renamed = MAX_AVG_VARIANCE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i3 >= iArr2.length) {
                break;
            }
            float fPatternMatchVariance = patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f_renamed) {
                i2 = i3;
                f_renamed = fPatternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:55:0x00e2, code lost:
    
        if (r5 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:81:0x0134, code lost:
    
        if (r5 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:82:0x0136, code lost:
    
        r5 = false;
        r10 = 'd_renamed';
        r11 = false;
     */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:44:0x00c2. Please report as_renamed an_renamed issue. */
    /* JADX WARN: Failed to find 'out' block for switch in_renamed B_renamed:69:0x010f. Please report as_renamed an_renamed issue. */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:84:0x0140 A_renamed[PHI: r19
      0x0140: PHI (r19v9 boolean) = (r19v5 boolean), (r19v17 boolean) binds: [B_renamed:69:0x010f, B_renamed:44:0x00c2] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:87:0x0149 A_renamed[PHI: r19
      0x0149: PHI (r19v7 boolean) = (r19v5 boolean), (r19v17 boolean) binds: [B_renamed:68:0x010d, B_renamed:43:0x00c0] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.zxing.Result decodeRow(int r25, com.google.zxing.common.BitArray r26, java.util.Map<com.google.zxing.DecodeHintType, ?> r27) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
