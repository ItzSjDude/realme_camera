package com.google.zxing.pdf417.detector;

/* loaded from: classes.dex */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    public static com.google.zxing.pdf417.detector.PDF417DetectorResult detect(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map, boolean z_renamed) throws com.google.zxing.NotFoundException {
        com.google.zxing.common.BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        java.util.List<com.google.zxing.ResultPoint[]> listDetect = detect(z_renamed, blackMatrix);
        if (listDetect.isEmpty()) {
            blackMatrix = blackMatrix.m29clone();
            blackMatrix.rotate180();
            listDetect = detect(z_renamed, blackMatrix);
        }
        return new com.google.zxing.pdf417.detector.PDF417DetectorResult(blackMatrix, listDetect);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:10:0x001d, code lost:
    
        if (r5 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:11:0x001f, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:13:0x0027, code lost:
    
        if (r4.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:14:0x0029, code lost:
    
        r5 = (com.google.zxing.ResultPoint[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:15:0x0031, code lost:
    
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:16:0x0033, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].getY());
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:18:0x0041, code lost:
    
        if (r5[3] == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:19:0x0043, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].getY());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r8, com.google.zxing.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = r2
            r4 = r3
        L9:
            r5 = r4
        La:
            int r6 = r9.getHeight()
            if (r3 >= r6) goto L7d
            com.google.zxing.ResultPoint[] r4 = findVertices(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 == 0) goto L7d
            java.util.Iterator r4 = r0.iterator()
        L23:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4f
            java.lang.Object r5 = r4.next()
            com.google.zxing.ResultPoint[] r5 = (com.google.zxing.ResultPoint[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L3f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.getY()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L3f:
            r7 = r5[r6]
            if (r7 == 0) goto L23
            r5 = r5[r6]
            float r5 = r5.getY()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L23
        L4f:
            int r3 = r3 + 5
            r4 = r2
            goto L9
        L53:
            r0.add(r4)
            if (r8 == 0) goto L7d
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6b
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
            goto L79
        L6b:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
        L79:
            int r3 = (int) r3
            r4 = r5
            r5 = r1
            goto La
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }

    private static com.google.zxing.ResultPoint[] findVertices(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        com.google.zxing.ResultPoint[] resultPointArr = new com.google.zxing.ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i_renamed, i2, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i2 = (int) resultPointArr[4].getX();
            i_renamed = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i_renamed, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static void copyToResult(com.google.zxing.ResultPoint[] resultPointArr, com.google.zxing.ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            resultPointArr[iArr[i_renamed]] = resultPointArr2[i_renamed];
        }
    }

    private static com.google.zxing.ResultPoint[] findRowsWithPattern(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2, int i3, int i4, int[] iArr) {
        boolean z_renamed;
        int i5;
        int[] iArr2;
        com.google.zxing.ResultPoint[] resultPointArr = new com.google.zxing.ResultPoint[4];
        int[] iArr3 = new int[iArr.length];
        int i6 = i3;
        while (true) {
            if (i6 >= i_renamed) {
                z_renamed = false;
                break;
            }
            int[] iArrFindGuardPattern = findGuardPattern(bitMatrix, i4, i6, i2, false, iArr, iArr3);
            if (iArrFindGuardPattern != null) {
                while (true) {
                    iArr2 = iArrFindGuardPattern;
                    if (i6 <= 0) {
                        break;
                    }
                    i6--;
                    iArrFindGuardPattern = findGuardPattern(bitMatrix, i4, i6, i2, false, iArr, iArr3);
                    if (iArrFindGuardPattern == null) {
                        i6++;
                        break;
                    }
                }
                float f_renamed = i6;
                resultPointArr[0] = new com.google.zxing.ResultPoint(iArr2[0], f_renamed);
                resultPointArr[1] = new com.google.zxing.ResultPoint(iArr2[1], f_renamed);
                z_renamed = true;
            } else {
                i6 += 5;
            }
        }
        int i7 = i6 + 1;
        if (z_renamed) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i8 = i7;
            int i9 = 0;
            while (true) {
                if (i8 >= i_renamed) {
                    i5 = i9;
                    break;
                }
                i5 = i9;
                int[] iArrFindGuardPattern2 = findGuardPattern(bitMatrix, iArr4[0], i8, i2, false, iArr, iArr3);
                if (iArrFindGuardPattern2 != null && java.lang.Math.abs(iArr4[0] - iArrFindGuardPattern2[0]) < 5 && java.lang.Math.abs(iArr4[1] - iArrFindGuardPattern2[1]) < 5) {
                    iArr4 = iArrFindGuardPattern2;
                    i9 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i9 = i5 + 1;
                }
                i8++;
            }
            i7 = i8 - (i5 + 1);
            float f2 = i7;
            resultPointArr[2] = new com.google.zxing.ResultPoint(iArr4[0], f2);
            resultPointArr[3] = new com.google.zxing.ResultPoint(iArr4[1], f2);
        }
        if (i7 - i6 < 10) {
            java.util.Arrays.fill(resultPointArr, (java.lang.Object) null);
        }
        return resultPointArr;
    }

    private static int[] findGuardPattern(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2, int i3, boolean z_renamed, int[] iArr, int[] iArr2) {
        java.util.Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.get(i_renamed, i2) && i_renamed > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i_renamed--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i_renamed;
        boolean z2 = z_renamed;
        int i7 = 0;
        while (true) {
            if (i_renamed >= i3) {
                if (i7 != length - 1 || patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) >= MAX_AVG_VARIANCE) {
                    return null;
                }
                return new int[]{i6, i_renamed - 1};
            }
            if (bitMatrix.get(i_renamed, i2) != z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i6, i_renamed};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    java.lang.System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z2 = z2 ? false : true;
            }
            i_renamed++;
        }
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f_renamed) {
        int length = iArr.length;
        int i_renamed = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i_renamed += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i_renamed < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i_renamed;
        float f3 = f2 / i2;
        float f4 = f_renamed * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
