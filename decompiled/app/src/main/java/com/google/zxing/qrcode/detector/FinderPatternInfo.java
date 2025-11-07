package com.google.zxing.qrcode.detector;

/* loaded from: classes.dex */
public final class FinderPatternInfo {
    private final com.google.zxing.qrcode.detector.FinderPattern bottomLeft;
    private final com.google.zxing.qrcode.detector.FinderPattern topLeft;
    private final com.google.zxing.qrcode.detector.FinderPattern topRight;

    public FinderPatternInfo(com.google.zxing.qrcode.detector.FinderPattern[] finderPatternArr) {
        this.bottomLeft = finderPatternArr[0];
        this.topLeft = finderPatternArr[1];
        this.topRight = finderPatternArr[2];
    }

    public com.google.zxing.qrcode.detector.FinderPattern getBottomLeft() {
        return this.bottomLeft;
    }

    public com.google.zxing.qrcode.detector.FinderPattern getTopLeft() {
        return this.topLeft;
    }

    public com.google.zxing.qrcode.detector.FinderPattern getTopRight() {
        return this.topRight;
    }
}
