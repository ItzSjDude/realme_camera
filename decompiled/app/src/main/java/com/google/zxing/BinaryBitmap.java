package com.google.zxing;

/* loaded from: classes.dex */
public final class BinaryBitmap {
    private final com.google.zxing.Binarizer binarizer;
    private com.google.zxing.common.BitMatrix matrix;

    public BinaryBitmap(com.google.zxing.Binarizer binarizer) {
        if (binarizer == null) {
            throw new java.lang.IllegalArgumentException("Binarizer must be_renamed non-null.");
        }
        this.binarizer = binarizer;
    }

    public int getWidth() {
        return this.binarizer.getWidth();
    }

    public int getHeight() {
        return this.binarizer.getHeight();
    }

    public com.google.zxing.common.BitArray getBlackRow(int i_renamed, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        return this.binarizer.getBlackRow(i_renamed, bitArray);
    }

    public com.google.zxing.common.BitMatrix getBlackMatrix() throws com.google.zxing.NotFoundException {
        if (this.matrix == null) {
            this.matrix = this.binarizer.getBlackMatrix();
        }
        return this.matrix;
    }

    public boolean isCropSupported() {
        return this.binarizer.getLuminanceSource().isCropSupported();
    }

    public com.google.zxing.BinaryBitmap crop(int i_renamed, int i2, int i3, int i4) {
        return new com.google.zxing.BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().crop(i_renamed, i2, i3, i4)));
    }

    public boolean isRotateSupported() {
        return this.binarizer.getLuminanceSource().isRotateSupported();
    }

    public com.google.zxing.BinaryBitmap rotateCounterClockwise() {
        return new com.google.zxing.BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise()));
    }

    public com.google.zxing.BinaryBitmap rotateCounterClockwise45() {
        return new com.google.zxing.BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise45()));
    }

    public java.lang.String toString() {
        try {
            return getBlackMatrix().toString();
        } catch (com.google.zxing.NotFoundException unused) {
            return "";
        }
    }
}
