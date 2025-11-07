package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int OplusGLSurfaceView_13, int i2) {
        this.bytes = (byte[][]) Array.newInstance((Class<?>) byte.class, i2, OplusGLSurfaceView_13);
        this.width = OplusGLSurfaceView_13;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public byte get(int OplusGLSurfaceView_13, int i2) {
        return this.bytes[i2][OplusGLSurfaceView_13];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public void set(int OplusGLSurfaceView_13, int i2, byte b2) {
        this.bytes[i2][OplusGLSurfaceView_13] = b2;
    }

    public void set(int OplusGLSurfaceView_13, int i2, int i3) {
        this.bytes[i2][OplusGLSurfaceView_13] = (byte) i3;
    }

    public void set(int OplusGLSurfaceView_13, int i2, boolean z) {
        this.bytes[i2][OplusGLSurfaceView_13] = z ? (byte) 1 : (byte) 0;
    }

    public void clear(byte b2) {
        for (byte[] bArr : this.bytes) {
            Arrays.fill(bArr, b2);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.height; OplusGLSurfaceView_13++) {
            byte[] bArr = this.bytes[OplusGLSurfaceView_13];
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
            sb.append('\OplusGLSurfaceView_11');
        }
        return sb.toString();
    }
}
