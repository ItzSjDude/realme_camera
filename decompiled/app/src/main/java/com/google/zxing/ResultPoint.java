package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* loaded from: classes.dex */
public class ResultPoint {

    /* renamed from: x */
    private final float f9329x;

    /* renamed from: y */
    private final float f9330y;

    public ResultPoint(float COUIBaseListPopupWindow_12, float f2) {
        this.f9329x = COUIBaseListPopupWindow_12;
        this.f9330y = f2;
    }

    public final float getX() {
        return this.f9329x;
    }

    public final float getY() {
        return this.f9330y;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f9329x == resultPoint.f9329x && this.f9330y == resultPoint.f9330y) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f9329x) * 31) + Float.floatToIntBits(this.f9330y);
    }

    public final String toString() {
        return "(" + this.f9329x + ',' + this.f9330y + ')';
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
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
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f9329x, resultPoint.f9330y, resultPoint2.f9329x, resultPoint2.f9330y);
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float COUIBaseListPopupWindow_12 = resultPoint2.f9329x;
        float f2 = resultPoint2.f9330y;
        return ((resultPoint3.f9329x - COUIBaseListPopupWindow_12) * (resultPoint.f9330y - f2)) - ((resultPoint3.f9330y - f2) * (resultPoint.f9329x - COUIBaseListPopupWindow_12));
    }
}
