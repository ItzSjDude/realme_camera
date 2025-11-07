package com.google.zxing.pdf417.decoder.p102ec;

import com.google.zxing.pdf417.PDF417Common;

/* loaded from: classes.dex */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    private ModulusGF(int OplusGLSurfaceView_13, int i2) {
        this.modulus = OplusGLSurfaceView_13;
        this.expTable = new int[OplusGLSurfaceView_13];
        this.logTable = new int[OplusGLSurfaceView_13];
        int i3 = 1;
        for (int i4 = 0; i4 < OplusGLSurfaceView_13; i4++) {
            this.expTable[i4] = i3;
            i3 = (i3 * i2) % OplusGLSurfaceView_13;
        }
        for (int i5 = 0; i5 < OplusGLSurfaceView_13 - 1; i5++) {
            this.logTable[this.expTable[i5]] = i5;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    ModulusPoly getZero() {
        return this.zero;
    }

    ModulusPoly getOne() {
        return this.one;
    }

    ModulusPoly buildMonomial(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[OplusGLSurfaceView_13 + 1];
        iArr[0] = i2;
        return new ModulusPoly(this, iArr);
    }

    int add(int OplusGLSurfaceView_13, int i2) {
        return (OplusGLSurfaceView_13 + i2) % this.modulus;
    }

    int subtract(int OplusGLSurfaceView_13, int i2) {
        int i3 = this.modulus;
        return ((OplusGLSurfaceView_13 + i3) - i2) % i3;
    }

    int exp(int OplusGLSurfaceView_13) {
        return this.expTable[OplusGLSurfaceView_13];
    }

    int log(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            throw new IllegalArgumentException();
        }
        return this.logTable[OplusGLSurfaceView_13];
    }

    int inverse(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            throw new ArithmeticException();
        }
        return this.expTable[(this.modulus - this.logTable[OplusGLSurfaceView_13]) - 1];
    }

    int multiply(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[OplusGLSurfaceView_13] + iArr2[i2]) % (this.modulus - 1)];
    }

    int getSize() {
        return this.modulus;
    }
}
