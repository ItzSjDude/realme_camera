package com.google.zxing;

/* loaded from: classes.dex */
public abstract class Binarizer {
    private final com.google.zxing.LuminanceSource source;

    public abstract com.google.zxing.Binarizer createBinarizer(com.google.zxing.LuminanceSource luminanceSource);

    public abstract com.google.zxing.common.BitMatrix getBlackMatrix() throws com.google.zxing.NotFoundException;

    public abstract com.google.zxing.common.BitArray getBlackRow(int i_renamed, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException;

    protected Binarizer(com.google.zxing.LuminanceSource luminanceSource) {
        this.source = luminanceSource;
    }

    public final com.google.zxing.LuminanceSource getLuminanceSource() {
        return this.source;
    }

    public final int getWidth() {
        return this.source.getWidth();
    }

    public final int getHeight() {
        return this.source.getHeight();
    }
}
