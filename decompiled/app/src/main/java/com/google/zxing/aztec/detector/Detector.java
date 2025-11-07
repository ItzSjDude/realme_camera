package com.google.zxing.aztec.detector;

/* loaded from: classes.dex */
public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = {3808, 476, 2107, 1799};
    private boolean compact;
    private final com.google.zxing.common.BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    public Detector(com.google.zxing.common.BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    public com.google.zxing.aztec.AztecDetectorResult detect() throws com.google.zxing.NotFoundException {
        return detect(false);
    }

    public com.google.zxing.aztec.AztecDetectorResult detect(boolean z_renamed) throws com.google.zxing.NotFoundException {
        com.google.zxing.ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
        if (z_renamed) {
            com.google.zxing.ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        extractParameters(bullsEyeCorners);
        com.google.zxing.common.BitMatrix bitMatrix = this.image;
        int i_renamed = this.shift;
        return new com.google.zxing.aztec.AztecDetectorResult(sampleGrid(bitMatrix, bullsEyeCorners[i_renamed % 4], bullsEyeCorners[(i_renamed + 1) % 4], bullsEyeCorners[(i_renamed + 2) % 4], bullsEyeCorners[(i_renamed + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }

    private void extractParameters(com.google.zxing.ResultPoint[] resultPointArr) throws com.google.zxing.NotFoundException {
        long j_renamed;
        long j2;
        if (!isValid(resultPointArr[0]) || !isValid(resultPointArr[1]) || !isValid(resultPointArr[2]) || !isValid(resultPointArr[3])) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i_renamed = this.nbCenterLayers * 2;
        int[] iArr = {sampleLine(resultPointArr[0], resultPointArr[1], i_renamed), sampleLine(resultPointArr[1], resultPointArr[2], i_renamed), sampleLine(resultPointArr[2], resultPointArr[3], i_renamed), sampleLine(resultPointArr[3], resultPointArr[0], i_renamed)};
        this.shift = getRotation(iArr, i_renamed);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.shift + i2) % 4];
            if (this.compact) {
                j_renamed = j3 << 7;
                j2 = (i3 >> 1) & 127;
            } else {
                j_renamed = j3 << 10;
                j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
            }
            j3 = j_renamed + j2;
        }
        int correctedParameterData = getCorrectedParameterData(j3, this.compact);
        if (this.compact) {
            this.nbLayers = (correctedParameterData >> 6) + 1;
            this.nbDataBlocks = (correctedParameterData & 63) + 1;
        } else {
            this.nbLayers = (correctedParameterData >> 11) + 1;
            this.nbDataBlocks = (correctedParameterData & 2047) + 1;
        }
    }

    private static int getRotation(int[] iArr, int i_renamed) throws com.google.zxing.NotFoundException {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i_renamed - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (java.lang.Integer.bitCount(EXPECTED_CORNER_BITS[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    private static int getCorrectedParameterData(long j_renamed, boolean z_renamed) throws com.google.zxing.NotFoundException {
        int i_renamed;
        int i2;
        if (z_renamed) {
            i_renamed = 7;
            i2 = 2;
        } else {
            i_renamed = 10;
            i2 = 4;
        }
        int i3 = i_renamed - i2;
        int[] iArr = new int[i_renamed];
        for (int i4 = i_renamed - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j_renamed) & 15;
            j_renamed >>= 4;
        }
        try {
            new com.google.zxing.common.reedsolomon.ReedSolomonDecoder(com.google.zxing.common.reedsolomon.GenericGF.AZTEC_PARAM).decode(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (com.google.zxing.common.reedsolomon.ReedSolomonException unused) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
    }

    private com.google.zxing.ResultPoint[] getBullsEyeCorners(com.google.zxing.aztec.detector.Detector.Point point) throws com.google.zxing.NotFoundException {
        this.nbCenterLayers = 1;
        com.google.zxing.aztec.detector.Detector.Point point2 = point;
        com.google.zxing.aztec.detector.Detector.Point point3 = point2;
        com.google.zxing.aztec.detector.Detector.Point point4 = point3;
        boolean z_renamed = true;
        while (this.nbCenterLayers < 9) {
            com.google.zxing.aztec.detector.Detector.Point firstDifferent = getFirstDifferent(point, z_renamed, 1, -1);
            com.google.zxing.aztec.detector.Detector.Point firstDifferent2 = getFirstDifferent(point2, z_renamed, 1, 1);
            com.google.zxing.aztec.detector.Detector.Point firstDifferent3 = getFirstDifferent(point3, z_renamed, -1, 1);
            com.google.zxing.aztec.detector.Detector.Point firstDifferent4 = getFirstDifferent(point4, z_renamed, -1, -1);
            if (this.nbCenterLayers > 2) {
                double dDistance = (distance(firstDifferent4, firstDifferent) * this.nbCenterLayers) / (distance(point4, point) * (this.nbCenterLayers + 2));
                if (dDistance < 0.75d || dDistance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            z_renamed = !z_renamed;
            this.nbCenterLayers++;
            point4 = firstDifferent4;
            point = firstDifferent;
            point2 = firstDifferent2;
            point3 = firstDifferent3;
        }
        int i_renamed = this.nbCenterLayers;
        if (i_renamed != 5 && i_renamed != 7) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        this.compact = this.nbCenterLayers == 5;
        com.google.zxing.ResultPoint[] resultPointArr = {new com.google.zxing.ResultPoint(point.getX() + 0.5f, point.getY() - 0.5f), new com.google.zxing.ResultPoint(point2.getX() + 0.5f, point2.getY() + 0.5f), new com.google.zxing.ResultPoint(point3.getX() - 0.5f, point3.getY() + 0.5f), new com.google.zxing.ResultPoint(point4.getX() - 0.5f, point4.getY() - 0.5f)};
        int i2 = this.nbCenterLayers;
        return expandSquare(resultPointArr, (i2 * 2) - 3, i2 * 2);
    }

    private com.google.zxing.aztec.detector.Detector.Point getMatrixCenter() {
        com.google.zxing.ResultPoint resultPoint;
        com.google.zxing.ResultPoint resultPoint2;
        com.google.zxing.ResultPoint resultPoint3;
        com.google.zxing.ResultPoint resultPoint4;
        com.google.zxing.ResultPoint resultPoint5;
        com.google.zxing.ResultPoint resultPoint6;
        com.google.zxing.ResultPoint resultPoint7;
        com.google.zxing.ResultPoint resultPoint8;
        try {
            com.google.zxing.ResultPoint[] resultPointArrDetect = new com.google.zxing.common.detector.WhiteRectangleDetector(this.image).detect();
            resultPoint3 = resultPointArrDetect[0];
            resultPoint4 = resultPointArrDetect[1];
            resultPoint2 = resultPointArrDetect[2];
            resultPoint = resultPointArrDetect[3];
        } catch (com.google.zxing.NotFoundException unused) {
            int width = this.image.getWidth() / 2;
            int height = this.image.getHeight() / 2;
            int i_renamed = width + 7;
            int i2 = height - 7;
            com.google.zxing.ResultPoint resultPoint9 = getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i_renamed, i2), false, 1, -1).toResultPoint();
            int i3 = height + 7;
            com.google.zxing.ResultPoint resultPoint10 = getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i_renamed, i3), false, 1, 1).toResultPoint();
            int i4 = width - 7;
            com.google.zxing.ResultPoint resultPoint11 = getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i4, i3), false, -1, 1).toResultPoint();
            resultPoint = getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i4, i2), false, -1, -1).toResultPoint();
            resultPoint2 = resultPoint11;
            resultPoint3 = resultPoint9;
            resultPoint4 = resultPoint10;
        }
        int iRound = com.google.zxing.common.detector.MathUtils.round((((resultPoint3.getX() + resultPoint.getX()) + resultPoint4.getX()) + resultPoint2.getX()) / 4.0f);
        int iRound2 = com.google.zxing.common.detector.MathUtils.round((((resultPoint3.getY() + resultPoint.getY()) + resultPoint4.getY()) + resultPoint2.getY()) / 4.0f);
        try {
            com.google.zxing.ResultPoint[] resultPointArrDetect2 = new com.google.zxing.common.detector.WhiteRectangleDetector(this.image, 15, iRound, iRound2).detect();
            resultPoint5 = resultPointArrDetect2[0];
            resultPoint6 = resultPointArrDetect2[1];
            resultPoint7 = resultPointArrDetect2[2];
            resultPoint8 = resultPointArrDetect2[3];
        } catch (com.google.zxing.NotFoundException unused2) {
            int i5 = iRound + 7;
            int i6 = iRound2 - 7;
            resultPoint5 = this.getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i5, i6), false, 1, -1).toResultPoint();
            int i7 = iRound2 + 7;
            resultPoint6 = this.getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i5, i7), false, 1, 1).toResultPoint();
            int i8 = iRound - 7;
            resultPoint7 = this.getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i8, i7), false, -1, 1).toResultPoint();
            resultPoint8 = this.getFirstDifferent(new com.google.zxing.aztec.detector.Detector.Point(i8, i6), false, -1, -1).toResultPoint();
        }
        return new com.google.zxing.aztec.detector.Detector.Point(com.google.zxing.common.detector.MathUtils.round((((resultPoint5.getX() + resultPoint8.getX()) + resultPoint6.getX()) + resultPoint7.getX()) / 4.0f), com.google.zxing.common.detector.MathUtils.round((((resultPoint5.getY() + resultPoint8.getY()) + resultPoint6.getY()) + resultPoint7.getY()) / 4.0f));
    }

    private com.google.zxing.ResultPoint[] getMatrixCornerPoints(com.google.zxing.ResultPoint[] resultPointArr) {
        return expandSquare(resultPointArr, this.nbCenterLayers * 2, getDimension());
    }

    private com.google.zxing.common.BitMatrix sampleGrid(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3, com.google.zxing.ResultPoint resultPoint4) throws com.google.zxing.NotFoundException {
        com.google.zxing.common.GridSampler gridSampler = com.google.zxing.common.GridSampler.getInstance();
        int dimension = getDimension();
        float f_renamed = dimension / 2.0f;
        int i_renamed = this.nbCenterLayers;
        float f2 = f_renamed - i_renamed;
        float f3 = f_renamed + i_renamed;
        return gridSampler.sampleGrid(bitMatrix, dimension, dimension, f2, f2, f3, f2, f3, f3, f2, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }

    private int sampleLine(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, int i_renamed) {
        float fDistance = distance(resultPoint, resultPoint2);
        float f_renamed = fDistance / i_renamed;
        float x_renamed = resultPoint.getX();
        float y_renamed = resultPoint.getY();
        float x2 = ((resultPoint2.getX() - resultPoint.getX()) * f_renamed) / fDistance;
        float y2 = (f_renamed * (resultPoint2.getY() - resultPoint.getY())) / fDistance;
        int i2 = 0;
        for (int i3 = 0; i3 < i_renamed; i3++) {
            float f2 = i3;
            if (this.image.get(com.google.zxing.common.detector.MathUtils.round((f2 * x2) + x_renamed), com.google.zxing.common.detector.MathUtils.round((f2 * y2) + y_renamed))) {
                i2 |= 1 << ((i_renamed - i3) - 1);
            }
        }
        return i2;
    }

    private boolean isWhiteOrBlackRectangle(com.google.zxing.aztec.detector.Detector.Point point, com.google.zxing.aztec.detector.Detector.Point point2, com.google.zxing.aztec.detector.Detector.Point point3, com.google.zxing.aztec.detector.Detector.Point point4) {
        com.google.zxing.aztec.detector.Detector.Point point5 = new com.google.zxing.aztec.detector.Detector.Point(point.getX() - 3, point.getY() + 3);
        com.google.zxing.aztec.detector.Detector.Point point6 = new com.google.zxing.aztec.detector.Detector.Point(point2.getX() - 3, point2.getY() - 3);
        com.google.zxing.aztec.detector.Detector.Point point7 = new com.google.zxing.aztec.detector.Detector.Point(point3.getX() + 3, point3.getY() - 3);
        com.google.zxing.aztec.detector.Detector.Point point8 = new com.google.zxing.aztec.detector.Detector.Point(point4.getX() + 3, point4.getY() + 3);
        int color = getColor(point8, point5);
        return color != 0 && getColor(point5, point6) == color && getColor(point6, point7) == color && getColor(point7, point8) == color;
    }

    private int getColor(com.google.zxing.aztec.detector.Detector.Point point, com.google.zxing.aztec.detector.Detector.Point point2) {
        float fDistance = distance(point, point2);
        float x_renamed = (point2.getX() - point.getX()) / fDistance;
        float y_renamed = (point2.getY() - point.getY()) / fDistance;
        float x2 = point.getX();
        float y2 = point.getY();
        boolean z_renamed = this.image.get(point.getX(), point.getY());
        int iCeil = (int) java.lang.Math.ceil(fDistance);
        float f_renamed = x2;
        float f2 = y2;
        int i_renamed = 0;
        for (int i2 = 0; i2 < iCeil; i2++) {
            f_renamed += x_renamed;
            f2 += y_renamed;
            if (this.image.get(com.google.zxing.common.detector.MathUtils.round(f_renamed), com.google.zxing.common.detector.MathUtils.round(f2)) != z_renamed) {
                i_renamed++;
            }
        }
        float f3 = i_renamed / fDistance;
        if (f3 <= 0.1f || f3 >= 0.9f) {
            return (f3 <= 0.1f) == z_renamed ? 1 : -1;
        }
        return 0;
    }

    private com.google.zxing.aztec.detector.Detector.Point getFirstDifferent(com.google.zxing.aztec.detector.Detector.Point point, boolean z_renamed, int i_renamed, int i2) {
        int x_renamed = point.getX() + i_renamed;
        int y_renamed = point.getY();
        while (true) {
            y_renamed += i2;
            if (!isValid(x_renamed, y_renamed) || this.image.get(x_renamed, y_renamed) != z_renamed) {
                break;
            }
            x_renamed += i_renamed;
        }
        int i3 = x_renamed - i_renamed;
        int i4 = y_renamed - i2;
        while (isValid(i3, i4) && this.image.get(i3, i4) == z_renamed) {
            i3 += i_renamed;
        }
        int i5 = i3 - i_renamed;
        while (isValid(i5, i4) && this.image.get(i5, i4) == z_renamed) {
            i4 += i2;
        }
        return new com.google.zxing.aztec.detector.Detector.Point(i5, i4 - i2);
    }

    private static com.google.zxing.ResultPoint[] expandSquare(com.google.zxing.ResultPoint[] resultPointArr, int i_renamed, int i2) {
        float f_renamed = i2 / (i_renamed * 2.0f);
        float x_renamed = resultPointArr[0].getX() - resultPointArr[2].getX();
        float y_renamed = resultPointArr[0].getY() - resultPointArr[2].getY();
        float x2 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y2 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float f2 = x_renamed * f_renamed;
        float f3 = y_renamed * f_renamed;
        com.google.zxing.ResultPoint resultPoint = new com.google.zxing.ResultPoint(x2 + f2, y2 + f3);
        com.google.zxing.ResultPoint resultPoint2 = new com.google.zxing.ResultPoint(x2 - f2, y2 - f3);
        float x3 = resultPointArr[1].getX() - resultPointArr[3].getX();
        float y3 = resultPointArr[1].getY() - resultPointArr[3].getY();
        float x4 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
        float y4 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
        float f4 = x3 * f_renamed;
        float f5 = f_renamed * y3;
        return new com.google.zxing.ResultPoint[]{resultPoint, new com.google.zxing.ResultPoint(x4 + f4, y4 + f5), resultPoint2, new com.google.zxing.ResultPoint(x4 - f4, y4 - f5)};
    }

    private boolean isValid(int i_renamed, int i2) {
        return i_renamed >= 0 && i_renamed < this.image.getWidth() && i2 > 0 && i2 < this.image.getHeight();
    }

    private boolean isValid(com.google.zxing.ResultPoint resultPoint) {
        return isValid(com.google.zxing.common.detector.MathUtils.round(resultPoint.getX()), com.google.zxing.common.detector.MathUtils.round(resultPoint.getY()));
    }

    private static float distance(com.google.zxing.aztec.detector.Detector.Point point, com.google.zxing.aztec.detector.Detector.Point point2) {
        return com.google.zxing.common.detector.MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
    }

    private static float distance(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2) {
        return com.google.zxing.common.detector.MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private int getDimension() {
        if (this.compact) {
            return (this.nbLayers * 4) + 11;
        }
        int i_renamed = this.nbLayers;
        return i_renamed <= 4 ? (i_renamed * 4) + 15 : (i_renamed * 4) + ((((i_renamed - 4) / 8) + 1) * 2) + 15;
    }

    static final class Point {
        private final int x_renamed;
        private final int y_renamed;

        com.google.zxing.ResultPoint toResultPoint() {
            return new com.google.zxing.ResultPoint(getX(), getY());
        }

        Point(int i_renamed, int i2) {
            this.x_renamed = i_renamed;
            this.y_renamed = i2;
        }

        int getX() {
            return this.x_renamed;
        }

        int getY() {
            return this.y_renamed;
        }

        public java.lang.String toString() {
            return "<" + this.x_renamed + ' ' + this.y_renamed + '>';
        }
    }
}
