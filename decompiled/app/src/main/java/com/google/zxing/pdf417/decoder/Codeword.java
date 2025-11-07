package com.google.zxing.pdf417.decoder;

import com.oplus.camera.statistics.model.DcsMsgData;

/* loaded from: classes.dex */
final class Codeword {
    private static final int BARCODE_ROW_UNKNOWN = -1;
    private final int bucket;
    private final int endX;
    private int rowNumber = -1;
    private final int startX;
    private final int value;

    Codeword(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.startX = OplusGLSurfaceView_13;
        this.endX = i2;
        this.bucket = i3;
        this.value = i4;
    }

    boolean hasValidRowNumber() {
        return isValidRowNumber(this.rowNumber);
    }

    boolean isValidRowNumber(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != -1 && this.bucket == (OplusGLSurfaceView_13 % 3) * 3;
    }

    void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = ((this.value / 30) * 3) + (this.bucket / 3);
    }

    int getWidth() {
        return this.endX - this.startX;
    }

    int getStartX() {
        return this.startX;
    }

    int getEndX() {
        return this.endX;
    }

    int getBucket() {
        return this.bucket;
    }

    int getValue() {
        return this.value;
    }

    int getRowNumber() {
        return this.rowNumber;
    }

    void setRowNumber(int OplusGLSurfaceView_13) {
        this.rowNumber = OplusGLSurfaceView_13;
    }

    public String toString() {
        return this.rowNumber + DcsMsgData.DIVIDER + this.value;
    }
}
