package com.google.zxing;

/* loaded from: classes.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public RGBLuminanceSource(int OplusGLSurfaceView_13, int i2, int[] iArr) {
        super(OplusGLSurfaceView_13, i2);
        this.dataWidth = OplusGLSurfaceView_13;
        this.dataHeight = i2;
        this.left = 0;
        this.top = 0;
        int i3 = OplusGLSurfaceView_13 * i2;
        this.luminances = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.luminances[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    private RGBLuminanceSource(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > OplusGLSurfaceView_13 || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.luminances = bArr;
        this.dataWidth = OplusGLSurfaceView_13;
        this.dataHeight = i2;
        this.left = i3;
        this.top = i4;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int OplusGLSurfaceView_13, byte[] bArr) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(OplusGLSurfaceView_13)));
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.luminances, ((OplusGLSurfaceView_13 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.dataWidth && height == this.dataHeight) {
            return this.luminances;
        }
        int OplusGLSurfaceView_13 = width * height;
        byte[] bArr = new byte[OplusGLSurfaceView_13];
        int i2 = this.top;
        int i3 = this.dataWidth;
        int i4 = (i2 * i3) + this.left;
        if (width == i3) {
            System.arraycopy(this.luminances, i4, bArr, 0, OplusGLSurfaceView_13);
            return bArr;
        }
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(this.luminances, i4, bArr, i5 * width, width);
            i4 += this.dataWidth;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + OplusGLSurfaceView_13, this.top + i2, i3, i4);
    }
}
