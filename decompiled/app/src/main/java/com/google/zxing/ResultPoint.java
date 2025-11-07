package com.google.zxing;

/* loaded from: classes.dex */
public class ResultPoint {
    private final float x_renamed;
    private final float y_renamed;

    public ResultPoint(float f_renamed, float f2) {
        this.x_renamed = f_renamed;
        this.y_renamed = f2;
    }

    public final float getX() {
        return this.x_renamed;
    }

    public final float getY() {
        return this.y_renamed;
    }

    public final boolean equals(java.lang.Object obj) {
        if (obj instanceof com.google.zxing.ResultPoint) {
            com.google.zxing.ResultPoint resultPoint = (com.google.zxing.ResultPoint) obj;
            if (this.x_renamed == resultPoint.x_renamed && this.y_renamed == resultPoint.y_renamed) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (java.lang.Float.floatToIntBits(this.x_renamed) * 31) + java.lang.Float.floatToIntBits(this.y_renamed);
    }

    public final java.lang.String toString() {
        return "(" + this.x_renamed + ',' + this.y_renamed + ')';
    }

    public static void orderBestPatterns(com.google.zxing.ResultPoint[] resultPointArr) {
        com.google.zxing.ResultPoint resultPoint;
        com.google.zxing.ResultPoint resultPoint2;
        com.google.zxing.ResultPoint resultPoint3;
        float fDistance = distance(resultPointArr[0], resultPointArr[1]);
        float fDistance2 = distance(resultPointArr[1], resultPointArr[2]);
        float fDistance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fDistance3 >= fDistance2 && fDistance3 >= fDistance) {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        } else {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            com.google.zxing.ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public static float distance(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2) {
        return com.google.zxing.common.detector.MathUtils.distance(resultPoint.x_renamed, resultPoint.y_renamed, resultPoint2.x_renamed, resultPoint2.y_renamed);
    }

    private static float crossProductZ(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3) {
        float f_renamed = resultPoint2.x_renamed;
        float f2 = resultPoint2.y_renamed;
        return ((resultPoint3.x_renamed - f_renamed) * (resultPoint.y_renamed - f2)) - ((resultPoint3.y_renamed - f2) * (resultPoint.x_renamed - f_renamed));
    }
}
