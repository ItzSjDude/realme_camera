package com.google.zxing.qrcode.detector;

/* loaded from: classes.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private static final com.google.zxing.qrcode.detector.FinderPatternFinder.EstimatedModuleComparator moduleComparator = new com.google.zxing.qrcode.detector.FinderPatternFinder.EstimatedModuleComparator();
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final com.google.zxing.common.BitMatrix image;
    private final java.util.List<com.google.zxing.qrcode.detector.FinderPattern> possibleCenters;
    private final com.google.zxing.ResultPointCallback resultPointCallback;

    public FinderPatternFinder(com.google.zxing.common.BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new java.util.ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    protected final com.google.zxing.common.BitMatrix getImage() {
        return this.image;
    }

    protected final java.util.List<com.google.zxing.qrcode.detector.FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    final com.google.zxing.qrcode.detector.FinderPatternInfo find(java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        boolean z_renamed = map != null && map.containsKey(com.google.zxing.DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i_renamed = (height * 3) / 388;
        if (i_renamed < 3 || z_renamed) {
            i_renamed = 3;
        }
        int[] iArr = new int[5];
        int i2 = i_renamed - 1;
        int i3 = i_renamed;
        boolean zHaveMultiplyConfirmedCenters = false;
        while (i2 < height && !zHaveMultiplyConfirmedCenters) {
            clearCounts(iArr);
            boolean zHaveMultiplyConfirmedCenters2 = zHaveMultiplyConfirmedCenters;
            int i4 = i3;
            int i5 = 0;
            int i6 = 0;
            while (i5 < width) {
                if (this.image.get(i5, i2)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 == 4) {
                    if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i5)) {
                        if (this.hasSkipped) {
                            zHaveMultiplyConfirmedCenters2 = haveMultiplyConfirmedCenters();
                        } else {
                            int iFindRowSkip = findRowSkip();
                            if (iFindRowSkip > iArr[2]) {
                                i2 += (iFindRowSkip - iArr[2]) - 2;
                                i5 = width - 1;
                            }
                        }
                        clearCounts(iArr);
                        i6 = 0;
                        i4 = 2;
                    } else {
                        shiftCounts2(iArr);
                        i6 = 3;
                    }
                } else {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                }
                i5++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width)) {
                int i7 = iArr[0];
                if (this.hasSkipped) {
                    i3 = i7;
                    zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                    i2 += i3;
                } else {
                    i3 = i7;
                }
            } else {
                i3 = i4;
            }
            zHaveMultiplyConfirmedCenters = zHaveMultiplyConfirmedCenters2;
            i2 += i3;
        }
        com.google.zxing.qrcode.detector.FinderPattern[] finderPatternArrSelectBestPatterns = selectBestPatterns();
        com.google.zxing.ResultPoint.orderBestPatterns(finderPatternArrSelectBestPatterns);
        return new com.google.zxing.qrcode.detector.FinderPatternInfo(finderPatternArrSelectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i_renamed) {
        return ((i_renamed - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i_renamed = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i_renamed += i3;
        }
        if (i_renamed < 7) {
            return false;
        }
        float f_renamed = i_renamed / 7.0f;
        float f2 = f_renamed / 2.0f;
        return java.lang.Math.abs(f_renamed - ((float) iArr[0])) < f2 && java.lang.Math.abs(f_renamed - ((float) iArr[1])) < f2 && java.lang.Math.abs((f_renamed * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && java.lang.Math.abs(f_renamed - ((float) iArr[3])) < f2 && java.lang.Math.abs(f_renamed - ((float) iArr[4])) < f2;
    }

    protected static boolean foundPatternDiagonal(int[] iArr) {
        int i_renamed = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i_renamed += i3;
        }
        if (i_renamed < 7) {
            return false;
        }
        float f_renamed = i_renamed / 7.0f;
        float f2 = f_renamed / 1.333f;
        return java.lang.Math.abs(f_renamed - ((float) iArr[0])) < f2 && java.lang.Math.abs(f_renamed - ((float) iArr[1])) < f2 && java.lang.Math.abs((f_renamed * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && java.lang.Math.abs(f_renamed - ((float) iArr[3])) < f2 && java.lang.Math.abs(f_renamed - ((float) iArr[4])) < f2;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    protected final void clearCounts(int[] iArr) {
        for (int i_renamed = 0; i_renamed < iArr.length; i_renamed++) {
            iArr[i_renamed] = 0;
        }
    }

    protected final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean crossCheckDiagonal(int i_renamed, int i2) {
        int i3;
        int i4;
        int i5;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = 0;
        while (i_renamed >= i6 && i2 >= i6 && this.image.get(i2 - i6, i_renamed - i6)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6++;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (i_renamed >= i6 && i2 >= i6 && !this.image.get(i2 - i6, i_renamed - i6)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i6++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (i_renamed >= i6 && i2 >= i6 && this.image.get(i2 - i6, i_renamed - i6)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i6++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i7 = 1;
        while (true) {
            int i8 = i_renamed + i7;
            if (i8 >= height || (i5 = i2 + i7) >= width || !this.image.get(i5, i8)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i_renamed + i7;
            if (i9 >= height || (i4 = i2 + i7) >= width || this.image.get(i4, i9)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i7++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i_renamed + i7;
            if (i10 >= height || (i3 = i2 + i7) >= width || !this.image.get(i3, i10)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i7++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    private float crossCheckVertical(int i_renamed, int i2, int i3, int i4) {
        com.google.zxing.common.BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i_renamed;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i5 >= 0 && bitMatrix.get(i2, i5) && crossCheckStateCount[0] <= i3) {
                crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
                i5--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i6 = i_renamed + 1;
            while (i6 < height && bitMatrix.get(i2, i6)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i6++;
            }
            if (i6 == height) {
                return Float.NaN;
            }
            while (i6 < height && !bitMatrix.get(i2, i6) && crossCheckStateCount[3] < i3) {
                crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
                i6++;
            }
            if (i6 != height && crossCheckStateCount[3] < i3) {
                while (i6 < height && bitMatrix.get(i2, i6) && crossCheckStateCount[4] < i3) {
                    crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
                    i6++;
                }
                if (crossCheckStateCount[4] < i3 && java.lang.Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 < i4 * 2 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i6);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int i_renamed, int i2, int i3, int i4) {
        com.google.zxing.common.BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i_renamed;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i5 >= 0 && bitMatrix.get(i5, i2) && crossCheckStateCount[0] <= i3) {
                crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
                i5--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i6 = i_renamed + 1;
            while (i6 < width && bitMatrix.get(i6, i2)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i6++;
            }
            if (i6 == width) {
                return Float.NaN;
            }
            while (i6 < width && !bitMatrix.get(i6, i2) && crossCheckStateCount[3] < i3) {
                crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
                i6++;
            }
            if (i6 != width && crossCheckStateCount[3] < i3) {
                while (i6 < width && bitMatrix.get(i6, i2) && crossCheckStateCount[4] < i3) {
                    crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
                    i6++;
                }
                if (crossCheckStateCount[4] < i3 && java.lang.Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 < i4 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i6);
                }
            }
        }
        return Float.NaN;
    }

    @java.lang.Deprecated
    protected final boolean handlePossibleCenter(int[] iArr, int i_renamed, int i2, boolean z_renamed) {
        return handlePossibleCenter(iArr, i_renamed, i2);
    }

    protected final boolean handlePossibleCenter(int[] iArr, int i_renamed, int i2) {
        boolean z_renamed = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iCenterFromEnd = (int) centerFromEnd(iArr, i2);
        float fCrossCheckVertical = crossCheckVertical(i_renamed, iCenterFromEnd, iArr[2], i3);
        if (!java.lang.Float.isNaN(fCrossCheckVertical)) {
            int i4 = (int) fCrossCheckVertical;
            float fCrossCheckHorizontal = crossCheckHorizontal(iCenterFromEnd, i4, iArr[2], i3);
            if (!java.lang.Float.isNaN(fCrossCheckHorizontal) && crossCheckDiagonal(i4, (int) fCrossCheckHorizontal)) {
                float f_renamed = i3 / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.possibleCenters.size()) {
                        break;
                    }
                    com.google.zxing.qrcode.detector.FinderPattern finderPattern = this.possibleCenters.get(i5);
                    if (finderPattern.aboutEquals(f_renamed, fCrossCheckVertical, fCrossCheckHorizontal)) {
                        this.possibleCenters.set(i5, finderPattern.combineEstimate(fCrossCheckVertical, fCrossCheckHorizontal, f_renamed));
                        z_renamed = true;
                        break;
                    }
                    i5++;
                }
                if (!z_renamed) {
                    com.google.zxing.qrcode.detector.FinderPattern finderPattern2 = new com.google.zxing.qrcode.detector.FinderPattern(fCrossCheckHorizontal, fCrossCheckVertical, f_renamed);
                    this.possibleCenters.add(finderPattern2);
                    com.google.zxing.ResultPointCallback resultPointCallback = this.resultPointCallback;
                    if (resultPointCallback != null) {
                        resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        com.google.zxing.qrcode.detector.FinderPattern finderPattern = null;
        for (com.google.zxing.qrcode.detector.FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (java.lang.Math.abs(finderPattern.getX() - finderPattern2.getX()) - java.lang.Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float fAbs = 0.0f;
        float estimatedModuleSize = 0.0f;
        int i_renamed = 0;
        for (com.google.zxing.qrcode.detector.FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i_renamed++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i_renamed < 3) {
            return false;
        }
        float f_renamed = estimatedModuleSize / size;
        java.util.Iterator<com.google.zxing.qrcode.detector.FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            fAbs += java.lang.Math.abs(it.next().getEstimatedModuleSize() - f_renamed);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    private static double squaredDistance(com.google.zxing.qrcode.detector.FinderPattern finderPattern, com.google.zxing.qrcode.detector.FinderPattern finderPattern2) {
        double x_renamed = finderPattern.getX() - finderPattern2.getX();
        double y_renamed = finderPattern.getY() - finderPattern2.getY();
        return (x_renamed * x_renamed) + (y_renamed * y_renamed);
    }

    private com.google.zxing.qrcode.detector.FinderPattern[] selectBestPatterns() throws com.google.zxing.NotFoundException {
        if (this.possibleCenters.size() < 3) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        this.possibleCenters.sort(moduleComparator);
        double[] dArr = new double[3];
        com.google.zxing.qrcode.detector.FinderPattern[] finderPatternArr = new com.google.zxing.qrcode.detector.FinderPattern[3];
        double d_renamed = Double.MAX_VALUE;
        int i_renamed = 0;
        while (i_renamed < this.possibleCenters.size() - 2) {
            com.google.zxing.qrcode.detector.FinderPattern finderPattern = this.possibleCenters.get(i_renamed);
            float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
            i_renamed++;
            double d2 = d_renamed;
            int i2 = i_renamed;
            while (i2 < this.possibleCenters.size() - 1) {
                com.google.zxing.qrcode.detector.FinderPattern finderPattern2 = this.possibleCenters.get(i2);
                double dSquaredDistance = squaredDistance(finderPattern, finderPattern2);
                i2++;
                double d3 = d2;
                for (int i3 = i2; i3 < this.possibleCenters.size(); i3++) {
                    com.google.zxing.qrcode.detector.FinderPattern finderPattern3 = this.possibleCenters.get(i3);
                    if (finderPattern3.getEstimatedModuleSize() <= 1.4f * estimatedModuleSize) {
                        dArr[0] = dSquaredDistance;
                        dArr[1] = squaredDistance(finderPattern2, finderPattern3);
                        dArr[2] = squaredDistance(finderPattern, finderPattern3);
                        java.util.Arrays.sort(dArr);
                        double dAbs = java.lang.Math.abs(dArr[2] - (dArr[1] * 2.0d)) + java.lang.Math.abs(dArr[2] - (dArr[0] * 2.0d));
                        if (dAbs < d3) {
                            finderPatternArr[0] = finderPattern;
                            finderPatternArr[1] = finderPattern2;
                            finderPatternArr[2] = finderPattern3;
                            d3 = dAbs;
                        }
                    }
                }
                d2 = d3;
            }
            d_renamed = d2;
        }
        if (d_renamed != Double.MAX_VALUE) {
            return finderPatternArr;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static final class EstimatedModuleComparator implements java.io.Serializable, java.util.Comparator<com.google.zxing.qrcode.detector.FinderPattern> {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.google.zxing.qrcode.detector.FinderPattern finderPattern, com.google.zxing.qrcode.detector.FinderPattern finderPattern2) {
            return java.lang.Float.compare(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
        }
    }
}
