package com.google.zxing.oned.rss;

/* loaded from: classes.dex */
final class Pair extends com.google.zxing.oned.rss.DataCharacter {
    private int count;
    private final com.google.zxing.oned.rss.FinderPattern finderPattern;

    Pair(int i_renamed, int i2, com.google.zxing.oned.rss.FinderPattern finderPattern) {
        super(i_renamed, i2);
        this.finderPattern = finderPattern;
    }

    com.google.zxing.oned.rss.FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    int getCount() {
        return this.count;
    }

    void incrementCount() {
        this.count++;
    }
}
