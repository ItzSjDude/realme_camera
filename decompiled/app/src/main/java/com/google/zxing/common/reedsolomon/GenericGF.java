package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
public final class GenericGF {
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_8;
    public static final com.google.zxing.common.reedsolomon.GenericGF DATA_MATRIX_FIELD_256;
    public static final com.google.zxing.common.reedsolomon.GenericGF MAXICODE_FIELD_64;
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final com.google.zxing.common.reedsolomon.GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final com.google.zxing.common.reedsolomon.GenericGFPoly zero;
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_12 = new com.google.zxing.common.reedsolomon.GenericGF(4201, 4096, 1);
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_10 = new com.google.zxing.common.reedsolomon.GenericGF(1033, 1024, 1);
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_DATA_6 = new com.google.zxing.common.reedsolomon.GenericGF(67, 64, 1);
    public static final com.google.zxing.common.reedsolomon.GenericGF AZTEC_PARAM = new com.google.zxing.common.reedsolomon.GenericGF(19, 16, 1);
    public static final com.google.zxing.common.reedsolomon.GenericGF QR_CODE_FIELD_256 = new com.google.zxing.common.reedsolomon.GenericGF(285, 256, 0);

    static int addOrSubtract(int i_renamed, int i2) {
        return i_renamed ^ i2;
    }

    static {
        com.google.zxing.common.reedsolomon.GenericGF genericGF = new com.google.zxing.common.reedsolomon.GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF;
        AZTEC_DATA_8 = genericGF;
        MAXICODE_FIELD_64 = AZTEC_DATA_6;
    }

    public GenericGF(int i_renamed, int i2, int i3) {
        this.primitive = i_renamed;
        this.size = i2;
        this.generatorBase = i3;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.expTable[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i_renamed) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.logTable[this.expTable[i6]] = i6;
        }
        this.zero = new com.google.zxing.common.reedsolomon.GenericGFPoly(this, new int[]{0});
        this.one = new com.google.zxing.common.reedsolomon.GenericGFPoly(this, new int[]{1});
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly getZero() {
        return this.zero;
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly getOne() {
        return this.one;
    }

    com.google.zxing.common.reedsolomon.GenericGFPoly buildMonomial(int i_renamed, int i2) {
        if (i_renamed < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i_renamed + 1];
        iArr[0] = i2;
        return new com.google.zxing.common.reedsolomon.GenericGFPoly(this, iArr);
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
        return this.expTable[(this.size - this.logTable[i_renamed]) - 1];
    }

    int multiply(int i_renamed, int i2) {
        if (i_renamed == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i_renamed] + iArr2[i2]) % (this.size - 1)];
    }

    public int getSize() {
        return this.size;
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    public java.lang.String toString() {
        return "GF(0x" + java.lang.Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
