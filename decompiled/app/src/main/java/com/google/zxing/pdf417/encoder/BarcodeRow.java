package com.google.zxing.pdf417.encoder;

/* loaded from: classes.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    BarcodeRow(int OplusGLSurfaceView_13) {
        this.row = new byte[OplusGLSurfaceView_13];
    }

    void set(int OplusGLSurfaceView_13, byte b2) {
        this.row[OplusGLSurfaceView_13] = b2;
    }

    private void set(int OplusGLSurfaceView_13, boolean z) {
        this.row[OplusGLSurfaceView_13] = z ? (byte) 1 : (byte) 0;
    }

    void addBar(boolean z, int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
            int i3 = this.currentLocation;
            this.currentLocation = i3 + 1;
            set(i3, z);
        }
    }

    byte[] getScaledRow(int OplusGLSurfaceView_13) {
        byte[] bArr = new byte[this.row.length * OplusGLSurfaceView_13];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.row[i2 / OplusGLSurfaceView_13];
        }
        return bArr;
    }
}
