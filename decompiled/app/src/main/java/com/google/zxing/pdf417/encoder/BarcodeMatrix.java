package com.google.zxing.pdf417.encoder;

/* loaded from: classes.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final com.google.zxing.pdf417.encoder.BarcodeRow[] matrix;
    private final int width;

    BarcodeMatrix(int i_renamed, int i2) {
        this.matrix = new com.google.zxing.pdf417.encoder.BarcodeRow[i_renamed];
        int length = this.matrix.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.matrix[i3] = new com.google.zxing.pdf417.encoder.BarcodeRow(((i2 + 4) * 17) + 1);
        }
        this.width = i2 * 17;
        this.height = i_renamed;
        this.currentRow = -1;
    }

    void set(int i_renamed, int i2, byte b2) {
        this.matrix[i2].set(i_renamed, b2);
    }

    void startRow() {
        this.currentRow++;
    }

    com.google.zxing.pdf417.encoder.BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i_renamed, int i2) {
        byte[][] bArr = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, this.height * i2, this.width * i_renamed);
        int i3 = this.height * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.matrix[i4 / i2].getScaledRow(i_renamed);
        }
        return bArr;
    }
}
