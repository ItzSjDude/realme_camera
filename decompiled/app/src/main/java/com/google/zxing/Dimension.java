package com.google.zxing;

/* loaded from: classes.dex */
public final class Dimension {
    private final int height;
    private final int width;

    public Dimension(int i_renamed, int i2) {
        if (i_renamed < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.width = i_renamed;
        this.height = i2;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.google.zxing.Dimension) {
            com.google.zxing.Dimension dimension = (com.google.zxing.Dimension) obj;
            if (this.width == dimension.width && this.height == dimension.height) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public java.lang.String toString() {
        return this.width + "x_renamed" + this.height;
    }
}
