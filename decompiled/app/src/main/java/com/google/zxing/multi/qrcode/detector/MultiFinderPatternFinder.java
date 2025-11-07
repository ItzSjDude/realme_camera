package com.google.zxing.multi.qrcode.detector;

/* loaded from: classes.dex */
final class MultiFinderPatternFinder extends com.google.zxing.qrcode.detector.FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;
    private static final com.google.zxing.qrcode.detector.FinderPatternInfo[] EMPTY_RESULT_ARRAY = new com.google.zxing.qrcode.detector.FinderPatternInfo[0];
    private static final com.google.zxing.qrcode.detector.FinderPattern[] EMPTY_FP_ARRAY = new com.google.zxing.qrcode.detector.FinderPattern[0];
    private static final com.google.zxing.qrcode.detector.FinderPattern[][] EMPTY_FP_2D_ARRAY = new com.google.zxing.qrcode.detector.FinderPattern[0][];

    private static final class ModuleSizeComparator implements java.io.Serializable, java.util.Comparator<com.google.zxing.qrcode.detector.FinderPattern> {
        private ModuleSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.google.zxing.qrcode.detector.FinderPattern finderPattern, com.google.zxing.qrcode.detector.FinderPattern finderPattern2) {
            double estimatedModuleSize = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
            if (estimatedModuleSize < 0.0d) {
                return -1;
            }
            return estimatedModuleSize > 0.0d ? 1 : 0;
        }
    }

    MultiFinderPatternFinder(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }

    private com.google.zxing.qrcode.detector.FinderPattern[][] selectMultipleBestPatterns() throws com.google.zxing.NotFoundException {
        java.util.List<com.google.zxing.qrcode.detector.FinderPattern> possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        int i_renamed = 3;
        if (size < 3) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        char c2 = 0;
        if (size == 3) {
            return new com.google.zxing.qrcode.detector.FinderPattern[][]{(com.google.zxing.qrcode.detector.FinderPattern[]) possibleCenters.toArray(EMPTY_FP_ARRAY)};
        }
        java.util.Collections.sort(possibleCenters, new com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder.ModuleSizeComparator());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        while (i2 < size - 2) {
            com.google.zxing.qrcode.detector.FinderPattern finderPattern = possibleCenters.get(i2);
            if (finderPattern != null) {
                int i3 = i2 + 1;
                while (i3 < size - 1) {
                    com.google.zxing.qrcode.detector.FinderPattern finderPattern2 = possibleCenters.get(i3);
                    if (finderPattern2 != null) {
                        float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / java.lang.Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        float fAbs = java.lang.Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize());
                        float f_renamed = DIFF_MODSIZE_CUTOFF;
                        float f2 = DIFF_MODSIZE_CUTOFF_PERCENT;
                        if (fAbs <= DIFF_MODSIZE_CUTOFF || estimatedModuleSize < DIFF_MODSIZE_CUTOFF_PERCENT) {
                            int i4 = i3 + 1;
                            while (i4 < size) {
                                com.google.zxing.qrcode.detector.FinderPattern finderPattern3 = possibleCenters.get(i4);
                                if (finderPattern3 != null) {
                                    float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / java.lang.Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                    if (java.lang.Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) <= f_renamed || estimatedModuleSize2 < f2) {
                                        com.google.zxing.qrcode.detector.FinderPattern[] finderPatternArr = new com.google.zxing.qrcode.detector.FinderPattern[i_renamed];
                                        finderPatternArr[c2] = finderPattern;
                                        finderPatternArr[1] = finderPattern2;
                                        finderPatternArr[2] = finderPattern3;
                                        com.google.zxing.ResultPoint.orderBestPatterns(finderPatternArr);
                                        com.google.zxing.qrcode.detector.FinderPatternInfo finderPatternInfo = new com.google.zxing.qrcode.detector.FinderPatternInfo(finderPatternArr);
                                        float fDistance = com.google.zxing.ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                        float fDistance2 = com.google.zxing.ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                        float fDistance3 = com.google.zxing.ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                        float estimatedModuleSize3 = (fDistance + fDistance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                        if (estimatedModuleSize3 <= MAX_MODULE_COUNT_PER_EDGE && estimatedModuleSize3 >= MIN_MODULE_COUNT_PER_EDGE && java.lang.Math.abs((fDistance - fDistance3) / java.lang.Math.min(fDistance, fDistance3)) < 0.1f) {
                                            double d_renamed = fDistance;
                                            double d2 = fDistance3;
                                            float fSqrt = (float) java.lang.Math.sqrt((d_renamed * d_renamed) + (d2 * d2));
                                            if (java.lang.Math.abs((fDistance2 - fSqrt) / java.lang.Math.min(fDistance2, fSqrt)) < 0.1f) {
                                                arrayList.add(finderPatternArr);
                                            }
                                        }
                                    }
                                }
                                i4++;
                                i_renamed = 3;
                                c2 = 0;
                                f_renamed = DIFF_MODSIZE_CUTOFF;
                                f2 = DIFF_MODSIZE_CUTOFF_PERCENT;
                            }
                        }
                    }
                    i3++;
                    i_renamed = 3;
                    c2 = 0;
                }
            }
            i2++;
            i_renamed = 3;
            c2 = 0;
        }
        if (!arrayList.isEmpty()) {
            return (com.google.zxing.qrcode.detector.FinderPattern[][]) arrayList.toArray(EMPTY_FP_2D_ARRAY);
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    public com.google.zxing.qrcode.detector.FinderPatternInfo[] findMulti(java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        boolean z_renamed = map != null && map.containsKey(com.google.zxing.DecodeHintType.TRY_HARDER);
        com.google.zxing.common.BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i_renamed = (height * 3) / 388;
        if (i_renamed < 3 || z_renamed) {
            i_renamed = 3;
        }
        int[] iArr = new int[5];
        for (int i2 = i_renamed - 1; i2 < height; i2 += i_renamed) {
            clearCounts(iArr);
            int i3 = 0;
            for (int i4 = 0; i4 < width; i4++) {
                if (image.get(i4, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 == 4) {
                    if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i4)) {
                        clearCounts(iArr);
                        i3 = 0;
                    } else {
                        shiftCounts2(iArr);
                        i3 = 3;
                    }
                } else {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                }
            }
            if (foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i2, width);
            }
        }
        com.google.zxing.qrcode.detector.FinderPattern[][] finderPatternArrSelectMultipleBestPatterns = selectMultipleBestPatterns();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.zxing.qrcode.detector.FinderPattern[] finderPatternArr : finderPatternArrSelectMultipleBestPatterns) {
            com.google.zxing.ResultPoint.orderBestPatterns(finderPatternArr);
            arrayList.add(new com.google.zxing.qrcode.detector.FinderPatternInfo(finderPatternArr));
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        return (com.google.zxing.qrcode.detector.FinderPatternInfo[]) arrayList.toArray(EMPTY_RESULT_ARRAY);
    }
}
