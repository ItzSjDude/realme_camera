package com.google.zxing.qrcode.detector;

/* loaded from: classes.dex */
public final class AlignmentPattern extends com.google.zxing.ResultPoint {
    private final float estimatedModuleSize;

    AlignmentPattern(float f_renamed, float f2, float f3) {
        super(f_renamed, f2);
        this.estimatedModuleSize = f3;
    }

    boolean aboutEquals(float f_renamed, float f2, float f3) {
        if (java.lang.Math.abs(f2 - getY()) > f_renamed || java.lang.Math.abs(f3 - getX()) > f_renamed) {
            return false;
        }
        float fAbs = java.lang.Math.abs(f_renamed - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    com.google.zxing.qrcode.detector.AlignmentPattern combineEstimate(float f_renamed, float f2, float f3) {
        return new com.google.zxing.qrcode.detector.AlignmentPattern((getX() + f2) / 2.0f, (getY() + f_renamed) / 2.0f, (this.estimatedModuleSize + f3) / 2.0f);
    }
}
