package com.google.zxing.pdf417.encoder;

/* loaded from: classes.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    BarcodeRow(int i_renamed) {
        this.row = new byte[i_renamed];
    }

    void set(int i_renamed, byte b2) {
        this.row[i_renamed] = b2;
    }

    private void set(int i_renamed, boolean z_renamed) {
        this.row[i_renamed] = z_renamed ? (byte) 1 : (byte) 0;
    }

    void addBar(boolean z_renamed, int i_renamed) {
        for (int i2 = 0; i2 < i_renamed; i2++) {
            int i3 = this.currentLocation;
            this.currentLocation = i3 + 1;
            set(i3, z_renamed);
        }
    }

    byte[] getScaledRow(int i_renamed) {
        byte[] bArr = new byte[this.row.length * i_renamed];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.row[i2 / i_renamed];
        }
        return bArr;
    }
}
