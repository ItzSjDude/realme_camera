package com.google.zxing.qrcode.detector;

/* loaded from: classes.dex */
final class AlignmentPatternFinder {
    private final int height;
    private final com.google.zxing.common.BitMatrix image;
    private final float moduleSize;
    private final com.google.zxing.ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;
    private final java.util.List<com.google.zxing.qrcode.detector.AlignmentPattern> possibleCenters = new java.util.ArrayList(5);
    private final int[] crossCheckStateCount = new int[3];

    AlignmentPatternFinder(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2, int i3, int i4, float f_renamed, com.google.zxing.ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i_renamed;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        this.moduleSize = f_renamed;
        this.resultPointCallback = resultPointCallback;
    }

    com.google.zxing.qrcode.detector.AlignmentPattern find() throws com.google.zxing.NotFoundException {
        com.google.zxing.qrcode.detector.AlignmentPattern alignmentPatternHandlePossibleCenter;
        com.google.zxing.qrcode.detector.AlignmentPattern alignmentPatternHandlePossibleCenter2;
        int i_renamed = this.startX;
        int i2 = this.height;
        int i3 = this.width + i_renamed;
        int i4 = this.startY + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i_renamed;
            while (i7 < i3 && !this.image.get(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.image.get(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 == 2) {
                    if (foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter2 = handlePossibleCenter(iArr, i6, i7)) != null) {
                        return alignmentPatternHandlePossibleCenter2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                } else {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                }
                i7++;
            }
            if (foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter = handlePossibleCenter(iArr, i6, i3)) != null) {
                return alignmentPatternHandlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static float centerFromEnd(int[] iArr, int i_renamed) {
        return (i_renamed - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean foundPatternCross(int[] iArr) {
        float f_renamed = this.moduleSize;
        float f2 = f_renamed / 2.0f;
        for (int i_renamed = 0; i_renamed < 3; i_renamed++) {
            if (java.lang.Math.abs(f_renamed - iArr[i_renamed]) >= f2) {
                return false;
            }
        }
        return true;
    }

    private float crossCheckVertical(int i_renamed, int i2, int i3, int i4) {
        com.google.zxing.common.BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i_renamed;
        while (i5 >= 0 && bitMatrix.get(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 >= 0 && iArr[1] <= i3) {
            while (i5 >= 0 && !bitMatrix.get(i2, i5) && iArr[0] <= i3) {
                iArr[0] = iArr[0] + 1;
                i5--;
            }
            if (iArr[0] > i3) {
                return Float.NaN;
            }
            int i6 = i_renamed + 1;
            while (i6 < height && bitMatrix.get(i2, i6) && iArr[1] <= i3) {
                iArr[1] = iArr[1] + 1;
                i6++;
            }
            if (i6 != height && iArr[1] <= i3) {
                while (i6 < height && !bitMatrix.get(i2, i6) && iArr[2] <= i3) {
                    iArr[2] = iArr[2] + 1;
                    i6++;
                }
                if (iArr[2] <= i3 && java.lang.Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 < i4 * 2 && foundPatternCross(iArr)) {
                    return centerFromEnd(iArr, i6);
                }
            }
        }
        return Float.NaN;
    }

    private com.google.zxing.qrcode.detector.AlignmentPattern handlePossibleCenter(int[] iArr, int i_renamed, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fCenterFromEnd = centerFromEnd(iArr, i2);
        float fCrossCheckVertical = crossCheckVertical(i_renamed, (int) fCenterFromEnd, iArr[1] * 2, i3);
        if (java.lang.Float.isNaN(fCrossCheckVertical)) {
            return null;
        }
        float f_renamed = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (com.google.zxing.qrcode.detector.AlignmentPattern alignmentPattern : this.possibleCenters) {
            if (alignmentPattern.aboutEquals(f_renamed, fCrossCheckVertical, fCenterFromEnd)) {
                return alignmentPattern.combineEstimate(fCrossCheckVertical, fCenterFromEnd, f_renamed);
            }
        }
        com.google.zxing.qrcode.detector.AlignmentPattern alignmentPattern2 = new com.google.zxing.qrcode.detector.AlignmentPattern(fCenterFromEnd, fCrossCheckVertical, f_renamed);
        this.possibleCenters.add(alignmentPattern2);
        com.google.zxing.ResultPointCallback resultPointCallback = this.resultPointCallback;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
        return null;
    }
}
