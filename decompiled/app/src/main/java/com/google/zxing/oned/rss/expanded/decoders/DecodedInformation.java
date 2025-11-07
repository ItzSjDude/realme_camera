package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class DecodedInformation extends com.google.zxing.oned.rss.expanded.decoders.DecodedObject {
    private final java.lang.String newString;
    private final boolean remaining;
    private final int remainingValue;

    DecodedInformation(int i_renamed, java.lang.String str) {
        super(i_renamed);
        this.newString = str;
        this.remaining = false;
        this.remainingValue = 0;
    }

    DecodedInformation(int i_renamed, java.lang.String str, int i2) {
        super(i_renamed);
        this.remaining = true;
        this.remainingValue = i2;
        this.newString = str;
    }

    java.lang.String getNewString() {
        return this.newString;
    }

    boolean isRemaining() {
        return this.remaining;
    }

    int getRemainingValue() {
        return this.remainingValue;
    }
}
