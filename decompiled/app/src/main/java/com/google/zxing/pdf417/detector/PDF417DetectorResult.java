package com.google.zxing.pdf417.detector;

/* loaded from: classes.dex */
public final class PDF417DetectorResult {
    private final com.google.zxing.common.BitMatrix bits;
    private final java.util.List<com.google.zxing.ResultPoint[]> points;

    public PDF417DetectorResult(com.google.zxing.common.BitMatrix bitMatrix, java.util.List<com.google.zxing.ResultPoint[]> list) {
        this.bits = bitMatrix;
        this.points = list;
    }

    public com.google.zxing.common.BitMatrix getBits() {
        return this.bits;
    }

    public java.util.List<com.google.zxing.ResultPoint[]> getPoints() {
        return this.points;
    }
}
