package com.google.zxing.qrcode.detector;

/* loaded from: classes.dex */
public final class FinderPattern extends com.google.zxing.ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    FinderPattern(float f_renamed, float f2, float f3) {
        this(f_renamed, f2, f3, 1);
    }

    private FinderPattern(float f_renamed, float f2, float f3, int i_renamed) {
        super(f_renamed, f2);
        this.estimatedModuleSize = f3;
        this.count = i_renamed;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    int getCount() {
        return this.count;
    }

    boolean aboutEquals(float f_renamed, float f2, float f3) {
        if (java.lang.Math.abs(f2 - getY()) > f_renamed || java.lang.Math.abs(f3 - getX()) > f_renamed) {
            return false;
        }
        float fAbs = java.lang.Math.abs(f_renamed - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    com.google.zxing.qrcode.detector.FinderPattern combineEstimate(float f_renamed, float f2, float f3) {
        int i_renamed = this.count;
        int i2 = i_renamed + 1;
        float x_renamed = (i_renamed * getX()) + f2;
        float f4 = i2;
        return new com.google.zxing.qrcode.detector.FinderPattern(x_renamed / f4, ((this.count * getY()) + f_renamed) / f4, ((this.count * this.estimatedModuleSize) + f3) / f4, i2);
    }
}
