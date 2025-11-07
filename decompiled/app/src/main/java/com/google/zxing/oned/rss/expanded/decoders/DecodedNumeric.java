package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class DecodedNumeric extends com.google.zxing.oned.rss.expanded.decoders.DecodedObject {
    static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    DecodedNumeric(int i_renamed, int i2, int i3) throws com.google.zxing.FormatException {
        super(i_renamed);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        this.firstDigit = i2;
        this.secondDigit = i3;
    }

    int getFirstDigit() {
        return this.firstDigit;
    }

    int getSecondDigit() {
        return this.secondDigit;
    }

    int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }

    boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }
}
