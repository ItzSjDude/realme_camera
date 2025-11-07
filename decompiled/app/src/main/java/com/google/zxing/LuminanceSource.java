package com.google.zxing;

/* loaded from: classes.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i_renamed, byte[] bArr);

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    protected LuminanceSource(int i_renamed, int i2) {
        this.width = i_renamed;
        this.height = i2;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public com.google.zxing.LuminanceSource crop(int i_renamed, int i2, int i3, int i4) {
        throw new java.lang.UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public com.google.zxing.LuminanceSource invert() {
        return new com.google.zxing.InvertedLuminanceSource(this);
    }

    public com.google.zxing.LuminanceSource rotateCounterClockwise() {
        throw new java.lang.UnsupportedOperationException("This luminance source does not support rotation by_renamed 90 degrees.");
    }

    public com.google.zxing.LuminanceSource rotateCounterClockwise45() {
        throw new java.lang.UnsupportedOperationException("This luminance source does not support rotation by_renamed 45 degrees.");
    }

    public final java.lang.String toString() {
        int i_renamed = this.width;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.height * (i_renamed + 1));
        byte[] row = new byte[i_renamed];
        for (int i2 = 0; i2 < this.height; i2++) {
            row = getRow(i2, row);
            for (int i3 = 0; i3 < this.width; i3++) {
                int i4 = row[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n_renamed');
        }
        return sb.toString();
    }
}
