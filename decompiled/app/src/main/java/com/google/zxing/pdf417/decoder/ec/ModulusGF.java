package com.google.zxing.pdf417.decoder.ec_renamed;

/* loaded from: classes.dex */
public final class ModulusGF {
    public static final com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF PDF417_GF = new com.google.zxing.pdf417.decoder.ec_renamed.ModulusGF(com.google.zxing.pdf417.PDF417Common.NUMBER_OF_CODEWORDS, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly one;
    private final com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly zero;

    private ModulusGF(int i_renamed, int i2) {
        this.modulus = i_renamed;
        this.expTable = new int[i_renamed];
        this.logTable = new int[i_renamed];
        int i3 = 1;
        for (int i4 = 0; i4 < i_renamed; i4++) {
            this.expTable[i4] = i3;
            i3 = (i3 * i2) % i_renamed;
        }
        for (int i5 = 0; i5 < i_renamed - 1; i5++) {
            this.logTable[this.expTable[i5]] = i5;
        }
        this.zero = new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this, new int[]{0});
        this.one = new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this, new int[]{1});
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly getZero() {
        return this.zero;
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly getOne() {
        return this.one;
    }

    com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly buildMonomial(int i_renamed, int i2) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i_renamed + 1];
        iArr[0] = i2;
        return new com.google.zxing.pdf417.decoder.ec_renamed.ModulusPoly(this, iArr);
    }

    int add(int i_renamed, int i2) {
        return (i_renamed + i2) % this.modulus;
    }

    int subtract(int i_renamed, int i2) {
        int i3 = this.modulus;
        return ((i_renamed + i3) - i2) % i3;
    }

    int exp(int i_renamed) {
        return this.expTable[i_renamed];
    }

    int log(int i_renamed) {
        if (i_renamed == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        return this.logTable[i_renamed];
    }

    int inverse(int i_renamed) {
        if (i_renamed == 0) {
            throw new java.lang.ArithmeticException();
        }
        return this.expTable[(this.modulus - this.logTable[i_renamed]) - 1];
    }

    int multiply(int i_renamed, int i2) {
        if (i_renamed == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i_renamed] + iArr2[i2]) % (this.modulus - 1)];
    }

    int getSize() {
        return this.modulus;
    }
}
