package com.google.zxing.qrcode.detector;

/* loaded from: classes.dex */
public class Detector {
    private final com.google.zxing.common.BitMatrix image;
    private com.google.zxing.ResultPointCallback resultPointCallback;

    public Detector(com.google.zxing.common.BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    protected final com.google.zxing.common.BitMatrix getImage() {
        return this.image;
    }

    protected final com.google.zxing.ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public com.google.zxing.common.DetectorResult detect() throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        return detect(null);
    }

    public final com.google.zxing.common.DetectorResult detect(java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        this.resultPointCallback = map == null ? null : (com.google.zxing.ResultPointCallback) map.get(com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return processFinderPatternInfo(new com.google.zxing.qrcode.detector.FinderPatternFinder(this.image, this.resultPointCallback).find(map));
    }

    protected final com.google.zxing.common.DetectorResult processFinderPatternInfo(com.google.zxing.qrcode.detector.FinderPatternInfo finderPatternInfo) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        com.google.zxing.ResultPoint[] resultPointArr;
        com.google.zxing.qrcode.detector.FinderPattern topLeft = finderPatternInfo.getTopLeft();
        com.google.zxing.qrcode.detector.FinderPattern topRight = finderPatternInfo.getTopRight();
        com.google.zxing.qrcode.detector.FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float fCalculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (fCalculateModuleSize < 1.0f) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int iComputeDimension = computeDimension(topLeft, topRight, bottomLeft, fCalculateModuleSize);
        com.google.zxing.qrcode.decoder.Version provisionalVersionForDimension = com.google.zxing.qrcode.decoder.Version.getProvisionalVersionForDimension(iComputeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        com.google.zxing.qrcode.detector.AlignmentPattern alignmentPatternFindAlignmentInRegion = null;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
            float x_renamed = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
            float y_renamed = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
            float f_renamed = 1.0f - (3.0f / dimensionForVersion);
            int x2 = (int) (topLeft.getX() + ((x_renamed - topLeft.getX()) * f_renamed));
            int y2 = (int) (topLeft.getY() + (f_renamed * (y_renamed - topLeft.getY())));
            for (int i_renamed = 4; i_renamed <= 16; i_renamed <<= 1) {
                try {
                    alignmentPatternFindAlignmentInRegion = findAlignmentInRegion(fCalculateModuleSize, x2, y2, i_renamed);
                    break;
                } catch (com.google.zxing.NotFoundException unused) {
                }
            }
        }
        com.google.zxing.common.BitMatrix bitMatrixSampleGrid = sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPatternFindAlignmentInRegion, iComputeDimension), iComputeDimension);
        if (alignmentPatternFindAlignmentInRegion == null) {
            resultPointArr = new com.google.zxing.ResultPoint[]{bottomLeft, topLeft, topRight};
        } else {
            resultPointArr = new com.google.zxing.ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPatternFindAlignmentInRegion};
        }
        return new com.google.zxing.common.DetectorResult(bitMatrixSampleGrid, resultPointArr);
    }

    private static com.google.zxing.common.PerspectiveTransform createTransform(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3, com.google.zxing.ResultPoint resultPoint4, int i_renamed) {
        float x_renamed;
        float y_renamed;
        float f_renamed;
        float f2 = i_renamed - 3.5f;
        if (resultPoint4 != null) {
            x_renamed = resultPoint4.getX();
            y_renamed = resultPoint4.getY();
            f_renamed = f2 - 3.0f;
        } else {
            x_renamed = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y_renamed = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f_renamed = f2;
        }
        return com.google.zxing.common.PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f2, 3.5f, f_renamed, f_renamed, 3.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x_renamed, y_renamed, resultPoint3.getX(), resultPoint3.getY());
    }

    private static com.google.zxing.common.BitMatrix sampleGrid(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.common.PerspectiveTransform perspectiveTransform, int i_renamed) throws com.google.zxing.NotFoundException {
        return com.google.zxing.common.GridSampler.getInstance().sampleGrid(bitMatrix, i_renamed, i_renamed, perspectiveTransform);
    }

    private static int computeDimension(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3, float f_renamed) throws com.google.zxing.NotFoundException {
        int iRound = ((com.google.zxing.common.detector.MathUtils.round(com.google.zxing.ResultPoint.distance(resultPoint, resultPoint2) / f_renamed) + com.google.zxing.common.detector.MathUtils.round(com.google.zxing.ResultPoint.distance(resultPoint, resultPoint3) / f_renamed)) / 2) + 7;
        int i_renamed = iRound & 3;
        if (i_renamed == 0) {
            return iRound + 1;
        }
        if (i_renamed == 2) {
            return iRound - 1;
        }
        if (i_renamed != 3) {
            return iRound;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    protected final float calculateModuleSize(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    private float calculateModuleSizeOneWay(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2) {
        float fSizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float fSizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        return java.lang.Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays) ? fSizeOfBlackWhiteBlackRunBothWays2 / 7.0f : java.lang.Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays2) ? fSizeOfBlackWhiteBlackRunBothWays / 7.0f : (fSizeOfBlackWhiteBlackRunBothWays + fSizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i_renamed, int i2, int i3, int i4) {
        int width;
        float width2;
        float height;
        float fSizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i_renamed, i2, i3, i4);
        int i5 = i_renamed - (i3 - i_renamed);
        int height2 = 0;
        if (i5 < 0) {
            width2 = i_renamed / (i_renamed - i5);
            width = 0;
        } else if (i5 >= this.image.getWidth()) {
            width2 = ((this.image.getWidth() - 1) - i_renamed) / (i5 - i_renamed);
            width = this.image.getWidth() - 1;
        } else {
            width = i5;
            width2 = 1.0f;
        }
        float f_renamed = i2;
        int i6 = (int) (f_renamed - ((i4 - i2) * width2));
        if (i6 < 0) {
            height = f_renamed / (i2 - i6);
        } else if (i6 >= this.image.getHeight()) {
            height = ((this.image.getHeight() - 1) - i2) / (i6 - i2);
            height2 = this.image.getHeight() - 1;
        } else {
            height2 = i6;
            height = 1.0f;
        }
        return (fSizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i_renamed, i2, (int) (i_renamed + ((width - i_renamed) * height)), height2)) - 1.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:40:0x0086, code lost:
    
        if (r14 != r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:42:0x008e, code lost:
    
        return com.google.zxing.common.detector.MathUtils.distance(r19, r5, r4, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:43:0x008f, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float sizeOfBlackWhiteBlackRun(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = r3
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r6 = r18
            r4 = r19
            r5 = r20
            r1 = r21
            goto L25
        L1d:
            r4 = r18
            r6 = r19
            r1 = r20
            r5 = r21
        L25:
            int r7 = r1 - r4
            int r7 = java.lang.Math.abs(r7)
            int r8 = r5 - r6
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r4 >= r1) goto L39
            r12 = r3
            goto L3a
        L39:
            r12 = r11
        L3a:
            if (r6 >= r5) goto L3d
            r11 = r3
        L3d:
            int r1 = r1 + r12
            r13 = r6
            r15 = r9
            r14 = 0
            r9 = r4
        L42:
            if (r9 == r1) goto L83
            if (r0 == 0) goto L48
            r2 = r13
            goto L49
        L48:
            r2 = r9
        L49:
            if (r0 == 0) goto L4d
            r10 = r9
            goto L4e
        L4d:
            r10 = r13
        L4e:
            if (r14 != r3) goto L58
            r16 = r0
            r19 = r1
            r0 = r3
            r3 = r17
            goto L5f
        L58:
            r3 = r17
            r16 = r0
            r19 = r1
            r0 = 0
        L5f:
            com.google.zxing.common.BitMatrix r1 = r3.image
            boolean r1 = r1.get(r2, r10)
            if (r0 != r1) goto L71
            r0 = 2
            if (r14 != r0) goto L6f
            float r0 = com.google.zxing.common.detector.MathUtils.distance(r9, r13, r4, r6)
            return r0
        L6f:
            int r14 = r14 + 1
        L71:
            int r15 = r15 + r8
            if (r15 <= 0) goto L7b
            if (r13 == r5) goto L79
            int r13 = r13 + r11
            int r15 = r15 - r7
            goto L7b
        L79:
            r0 = 2
            goto L86
        L7b:
            int r9 = r9 + r12
            r1 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L42
        L83:
            r19 = r1
            r0 = r10
        L86:
            if (r14 != r0) goto L8f
            r1 = r19
            float r0 = com.google.zxing.common.detector.MathUtils.distance(r1, r5, r4, r6)
            return r0
        L8f:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.sizeOfBlackWhiteBlackRun(int, int, int, int):float");
    }

    protected final com.google.zxing.qrcode.detector.AlignmentPattern findAlignmentInRegion(float f_renamed, int i_renamed, int i2, float f2) throws com.google.zxing.NotFoundException {
        int i3 = (int) (f2 * f_renamed);
        int iMax = java.lang.Math.max(0, i_renamed - i3);
        int iMin = java.lang.Math.min(this.image.getWidth() - 1, i_renamed + i3) - iMax;
        float f3 = 3.0f * f_renamed;
        if (iMin < f3) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int iMax2 = java.lang.Math.max(0, i2 - i3);
        int iMin2 = java.lang.Math.min(this.image.getHeight() - 1, i2 + i3) - iMax2;
        if (iMin2 < f3) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        return new com.google.zxing.qrcode.detector.AlignmentPatternFinder(this.image, iMax, iMax2, iMin, iMin2, f_renamed, this.resultPointCallback).find();
    }
}
