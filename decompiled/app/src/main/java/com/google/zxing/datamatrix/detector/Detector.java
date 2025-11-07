package com.google.zxing.datamatrix.detector;

/* loaded from: classes.dex */
public final class Detector {
    private final com.google.zxing.common.BitMatrix image;
    private final com.google.zxing.common.detector.WhiteRectangleDetector rectangleDetector;

    public Detector(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new com.google.zxing.common.detector.WhiteRectangleDetector(bitMatrix);
    }

    public com.google.zxing.common.DetectorResult detect() throws com.google.zxing.NotFoundException {
        int iMax;
        int i_renamed;
        com.google.zxing.ResultPoint[] resultPointArrDetectSolid2 = detectSolid2(detectSolid1(this.rectangleDetector.detect()));
        resultPointArrDetectSolid2[3] = correctTopRight(resultPointArrDetectSolid2);
        if (resultPointArrDetectSolid2[3] == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        com.google.zxing.ResultPoint[] resultPointArrShiftToModuleCenter = shiftToModuleCenter(resultPointArrDetectSolid2);
        com.google.zxing.ResultPoint resultPoint = resultPointArrShiftToModuleCenter[0];
        com.google.zxing.ResultPoint resultPoint2 = resultPointArrShiftToModuleCenter[1];
        com.google.zxing.ResultPoint resultPoint3 = resultPointArrShiftToModuleCenter[2];
        com.google.zxing.ResultPoint resultPoint4 = resultPointArrShiftToModuleCenter[3];
        int iTransitionsBetween = transitionsBetween(resultPoint, resultPoint4) + 1;
        int iTransitionsBetween2 = transitionsBetween(resultPoint3, resultPoint4) + 1;
        if ((iTransitionsBetween & 1) == 1) {
            iTransitionsBetween++;
        }
        if ((iTransitionsBetween2 & 1) == 1) {
            iTransitionsBetween2++;
        }
        if (iTransitionsBetween * 4 >= iTransitionsBetween2 * 7 || iTransitionsBetween2 * 4 >= iTransitionsBetween * 7) {
            iMax = iTransitionsBetween;
            i_renamed = iTransitionsBetween2;
        } else {
            iMax = java.lang.Math.max(iTransitionsBetween, iTransitionsBetween2);
            i_renamed = iMax;
        }
        return new com.google.zxing.common.DetectorResult(sampleGrid(this.image, resultPoint, resultPoint2, resultPoint3, resultPoint4, iMax, i_renamed), new com.google.zxing.ResultPoint[]{resultPoint, resultPoint2, resultPoint3, resultPoint4});
    }

    private static com.google.zxing.ResultPoint shiftPoint(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, int i_renamed) {
        float f_renamed = i_renamed + 1;
        return new com.google.zxing.ResultPoint(resultPoint.getX() + ((resultPoint2.getX() - resultPoint.getX()) / f_renamed), resultPoint.getY() + ((resultPoint2.getY() - resultPoint.getY()) / f_renamed));
    }

    private static com.google.zxing.ResultPoint moveAway(com.google.zxing.ResultPoint resultPoint, float f_renamed, float f2) {
        float x_renamed = resultPoint.getX();
        float y_renamed = resultPoint.getY();
        return new com.google.zxing.ResultPoint(x_renamed < f_renamed ? x_renamed - 1.0f : x_renamed + 1.0f, y_renamed < f2 ? y_renamed - 1.0f : y_renamed + 1.0f);
    }

    private com.google.zxing.ResultPoint[] detectSolid1(com.google.zxing.ResultPoint[] resultPointArr) {
        com.google.zxing.ResultPoint resultPoint = resultPointArr[0];
        com.google.zxing.ResultPoint resultPoint2 = resultPointArr[1];
        com.google.zxing.ResultPoint resultPoint3 = resultPointArr[3];
        com.google.zxing.ResultPoint resultPoint4 = resultPointArr[2];
        int iTransitionsBetween = transitionsBetween(resultPoint, resultPoint2);
        int iTransitionsBetween2 = transitionsBetween(resultPoint2, resultPoint3);
        int iTransitionsBetween3 = transitionsBetween(resultPoint3, resultPoint4);
        int iTransitionsBetween4 = transitionsBetween(resultPoint4, resultPoint);
        com.google.zxing.ResultPoint[] resultPointArr2 = {resultPoint4, resultPoint, resultPoint2, resultPoint3};
        if (iTransitionsBetween > iTransitionsBetween2) {
            resultPointArr2[0] = resultPoint;
            resultPointArr2[1] = resultPoint2;
            resultPointArr2[2] = resultPoint3;
            resultPointArr2[3] = resultPoint4;
            iTransitionsBetween = iTransitionsBetween2;
        }
        if (iTransitionsBetween > iTransitionsBetween3) {
            resultPointArr2[0] = resultPoint2;
            resultPointArr2[1] = resultPoint3;
            resultPointArr2[2] = resultPoint4;
            resultPointArr2[3] = resultPoint;
            iTransitionsBetween = iTransitionsBetween3;
        }
        if (iTransitionsBetween > iTransitionsBetween4) {
            resultPointArr2[0] = resultPoint3;
            resultPointArr2[1] = resultPoint4;
            resultPointArr2[2] = resultPoint;
            resultPointArr2[3] = resultPoint2;
        }
        return resultPointArr2;
    }

    private com.google.zxing.ResultPoint[] detectSolid2(com.google.zxing.ResultPoint[] resultPointArr) {
        com.google.zxing.ResultPoint resultPoint = resultPointArr[0];
        com.google.zxing.ResultPoint resultPoint2 = resultPointArr[1];
        com.google.zxing.ResultPoint resultPoint3 = resultPointArr[2];
        com.google.zxing.ResultPoint resultPoint4 = resultPointArr[3];
        int iTransitionsBetween = (transitionsBetween(resultPoint, resultPoint4) + 1) << 2;
        if (transitionsBetween(shiftPoint(resultPoint2, resultPoint3, iTransitionsBetween), resultPoint) < transitionsBetween(shiftPoint(resultPoint3, resultPoint2, iTransitionsBetween), resultPoint4)) {
            resultPointArr[0] = resultPoint;
            resultPointArr[1] = resultPoint2;
            resultPointArr[2] = resultPoint3;
            resultPointArr[3] = resultPoint4;
        } else {
            resultPointArr[0] = resultPoint2;
            resultPointArr[1] = resultPoint3;
            resultPointArr[2] = resultPoint4;
            resultPointArr[3] = resultPoint;
        }
        return resultPointArr;
    }

    private com.google.zxing.ResultPoint correctTopRight(com.google.zxing.ResultPoint[] resultPointArr) {
        com.google.zxing.ResultPoint resultPoint = resultPointArr[0];
        com.google.zxing.ResultPoint resultPoint2 = resultPointArr[1];
        com.google.zxing.ResultPoint resultPoint3 = resultPointArr[2];
        com.google.zxing.ResultPoint resultPoint4 = resultPointArr[3];
        int iTransitionsBetween = transitionsBetween(resultPoint, resultPoint4);
        com.google.zxing.ResultPoint resultPointShiftPoint = shiftPoint(resultPoint, resultPoint2, (transitionsBetween(resultPoint2, resultPoint4) + 1) << 2);
        com.google.zxing.ResultPoint resultPointShiftPoint2 = shiftPoint(resultPoint3, resultPoint2, (iTransitionsBetween + 1) << 2);
        int iTransitionsBetween2 = transitionsBetween(resultPointShiftPoint, resultPoint4);
        int iTransitionsBetween3 = transitionsBetween(resultPointShiftPoint2, resultPoint4);
        float f_renamed = iTransitionsBetween2 + 1;
        com.google.zxing.ResultPoint resultPoint5 = new com.google.zxing.ResultPoint(resultPoint4.getX() + ((resultPoint3.getX() - resultPoint2.getX()) / f_renamed), resultPoint4.getY() + ((resultPoint3.getY() - resultPoint2.getY()) / f_renamed));
        float f2 = iTransitionsBetween3 + 1;
        com.google.zxing.ResultPoint resultPoint6 = new com.google.zxing.ResultPoint(resultPoint4.getX() + ((resultPoint.getX() - resultPoint2.getX()) / f2), resultPoint4.getY() + ((resultPoint.getY() - resultPoint2.getY()) / f2));
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && transitionsBetween(resultPointShiftPoint, resultPoint5) + transitionsBetween(resultPointShiftPoint2, resultPoint5) <= transitionsBetween(resultPointShiftPoint, resultPoint6) + transitionsBetween(resultPointShiftPoint2, resultPoint6)) ? resultPoint6 : resultPoint5;
        }
        if (isValid(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    private com.google.zxing.ResultPoint[] shiftToModuleCenter(com.google.zxing.ResultPoint[] resultPointArr) {
        com.google.zxing.ResultPoint resultPoint = resultPointArr[0];
        com.google.zxing.ResultPoint resultPoint2 = resultPointArr[1];
        com.google.zxing.ResultPoint resultPoint3 = resultPointArr[2];
        com.google.zxing.ResultPoint resultPoint4 = resultPointArr[3];
        int iTransitionsBetween = transitionsBetween(resultPoint, resultPoint4) + 1;
        com.google.zxing.ResultPoint resultPointShiftPoint = shiftPoint(resultPoint, resultPoint2, (transitionsBetween(resultPoint3, resultPoint4) + 1) << 2);
        com.google.zxing.ResultPoint resultPointShiftPoint2 = shiftPoint(resultPoint3, resultPoint2, iTransitionsBetween << 2);
        int iTransitionsBetween2 = transitionsBetween(resultPointShiftPoint, resultPoint4) + 1;
        int iTransitionsBetween3 = transitionsBetween(resultPointShiftPoint2, resultPoint4) + 1;
        if ((iTransitionsBetween2 & 1) == 1) {
            iTransitionsBetween2++;
        }
        if ((iTransitionsBetween3 & 1) == 1) {
            iTransitionsBetween3++;
        }
        float x_renamed = (((resultPoint.getX() + resultPoint2.getX()) + resultPoint3.getX()) + resultPoint4.getX()) / 4.0f;
        float y_renamed = (((resultPoint.getY() + resultPoint2.getY()) + resultPoint3.getY()) + resultPoint4.getY()) / 4.0f;
        com.google.zxing.ResultPoint resultPointMoveAway = moveAway(resultPoint, x_renamed, y_renamed);
        com.google.zxing.ResultPoint resultPointMoveAway2 = moveAway(resultPoint2, x_renamed, y_renamed);
        com.google.zxing.ResultPoint resultPointMoveAway3 = moveAway(resultPoint3, x_renamed, y_renamed);
        com.google.zxing.ResultPoint resultPointMoveAway4 = moveAway(resultPoint4, x_renamed, y_renamed);
        int i_renamed = iTransitionsBetween3 << 2;
        int i2 = iTransitionsBetween2 << 2;
        return new com.google.zxing.ResultPoint[]{shiftPoint(shiftPoint(resultPointMoveAway, resultPointMoveAway2, i_renamed), resultPointMoveAway4, i2), shiftPoint(shiftPoint(resultPointMoveAway2, resultPointMoveAway, i_renamed), resultPointMoveAway3, i2), shiftPoint(shiftPoint(resultPointMoveAway3, resultPointMoveAway4, i_renamed), resultPointMoveAway2, i2), shiftPoint(shiftPoint(resultPointMoveAway4, resultPointMoveAway3, i_renamed), resultPointMoveAway, i2)};
    }

    private boolean isValid(com.google.zxing.ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static com.google.zxing.common.BitMatrix sampleGrid(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3, com.google.zxing.ResultPoint resultPoint4, int i_renamed, int i2) throws com.google.zxing.NotFoundException {
        float f_renamed = i_renamed - 0.5f;
        float f2 = i2 - 0.5f;
        return com.google.zxing.common.GridSampler.getInstance().sampleGrid(bitMatrix, i_renamed, i2, 0.5f, 0.5f, f_renamed, 0.5f, f_renamed, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private int transitionsBetween(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2) {
        int x_renamed = (int) resultPoint.getX();
        int y_renamed = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i_renamed = 0;
        boolean z_renamed = java.lang.Math.abs(y2 - y_renamed) > java.lang.Math.abs(x2 - x_renamed);
        if (z_renamed) {
            y_renamed = x_renamed;
            x_renamed = y_renamed;
            y2 = x2;
            x2 = y2;
        }
        int iAbs = java.lang.Math.abs(x2 - x_renamed);
        int iAbs2 = java.lang.Math.abs(y2 - y_renamed);
        int i2 = (-iAbs) / 2;
        int i3 = y_renamed < y2 ? 1 : -1;
        int i4 = x_renamed >= x2 ? -1 : 1;
        boolean z2 = this.image.get(z_renamed ? y_renamed : x_renamed, z_renamed ? x_renamed : y_renamed);
        while (x_renamed != x2) {
            boolean z3 = this.image.get(z_renamed ? y_renamed : x_renamed, z_renamed ? x_renamed : y_renamed);
            if (z3 != z2) {
                i_renamed++;
                z2 = z3;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (y_renamed == y2) {
                    break;
                }
                y_renamed += i3;
                i2 -= iAbs;
            }
            x_renamed += i4;
        }
        return i_renamed;
    }
}
