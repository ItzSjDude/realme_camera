package com.google.zxing.common;

/* loaded from: classes.dex */
public class DetectorResult {
    private final com.google.zxing.common.BitMatrix bits;
    private final com.google.zxing.ResultPoint[] points;

    public DetectorResult(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.ResultPoint[] resultPointArr) {
        this.bits = bitMatrix;
        this.points = resultPointArr;
    }

    public final com.google.zxing.common.BitMatrix getBits() {
        return this.bits;
    }

    public final com.google.zxing.ResultPoint[] getPoints() {
        return this.points;
    }
}
