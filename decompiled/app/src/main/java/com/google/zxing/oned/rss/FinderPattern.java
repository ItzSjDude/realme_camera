package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
public final class FinderPattern {
    private final com.google.zxing.ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i_renamed, int[] iArr, int i2, int i3, int i4) {
        this.value = i_renamed;
        this.startEnd = iArr;
        float f_renamed = i4;
        this.resultPoints = new com.google.zxing.ResultPoint[]{new com.google.zxing.ResultPoint(i2, f_renamed), new com.google.zxing.ResultPoint(i3, f_renamed)};
    }

    public int getValue() {
        return this.value;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public com.google.zxing.ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.google.zxing.oned.rss.FinderPattern) && this.value == ((com.google.zxing.oned.rss.FinderPattern) obj).value;
    }

    public int hashCode() {
        return this.value;
    }
}
