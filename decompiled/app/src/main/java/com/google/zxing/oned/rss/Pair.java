package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    Pair(int OplusGLSurfaceView_13, int i2, FinderPattern finderPattern) {
        super(OplusGLSurfaceView_13, i2);
        this.finderPattern = finderPattern;
    }

    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    int getCount() {
        return this.count;
    }

    void incrementCount() {
        this.count++;
    }
}
