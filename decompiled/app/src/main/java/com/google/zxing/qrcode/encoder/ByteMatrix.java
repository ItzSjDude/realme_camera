package com.google.zxing.qrcode.encoder;

/* loaded from: classes.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int i_renamed, int i2) {
        this.bytes = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, i2, i_renamed);
        this.width = i_renamed;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public byte get(int i_renamed, int i2) {
        return this.bytes[i2][i_renamed];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public void set(int i_renamed, int i2, byte b2) {
        this.bytes[i2][i_renamed] = b2;
    }

    public void set(int i_renamed, int i2, int i3) {
        this.bytes[i2][i_renamed] = (byte) i3;
    }

    public void set(int i_renamed, int i2, boolean z_renamed) {
        this.bytes[i2][i_renamed] = z_renamed ? (byte) 1 : (byte) 0;
    }

    public void clear(byte b2) {
        for (byte[] bArr : this.bytes) {
            java.util.Arrays.fill(bArr, b2);
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder((this.width * 2 * this.height) + 2);
        for (int i_renamed = 0; i_renamed < this.height; i_renamed++) {
            byte[] bArr = this.bytes[i_renamed];
            for (int i2 = 0; i2 < this.width; i2++) {
                byte b2 = bArr[i2];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 == 1) {
                    sb.append(" 1");
                } else {
                    sb.append("  ");
                }
            }
            sb.append('\n_renamed');
        }
        return sb.toString();
    }
}
