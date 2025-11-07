package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE = (float[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) float.class, com.google.zxing.pdf417.PDF417Common.SYMBOL_TABLE.length, 8);

    static {
        int i_renamed;
        for (int i2 = 0; i2 < com.google.zxing.pdf417.PDF417Common.SYMBOL_TABLE.length; i2++) {
            int i3 = com.google.zxing.pdf417.PDF417Common.SYMBOL_TABLE[i2];
            int i4 = i3 & 1;
            int i5 = i3;
            int i6 = 0;
            while (i6 < 8) {
                float f_renamed = 0.0f;
                while (true) {
                    i_renamed = i5 & 1;
                    if (i_renamed == i4) {
                        f_renamed += 1.0f;
                        i5 >>= 1;
                    }
                }
                RATIOS_TABLE[i2][(8 - i6) - 1] = f_renamed / 17.0f;
                i6++;
                i4 = i_renamed;
            }
        }
    }

    private PDF417CodewordDecoder() {
    }

    static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        return decodedCodewordValue != -1 ? decodedCodewordValue : getClosestDecodedValue(iArr);
    }

    private static int[] sampleBitCounts(int[] iArr) {
        float fSum = com.google.zxing.common.detector.MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i_renamed = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (iArr[i2] + i_renamed <= (fSum / 34.0f) + ((i3 * fSum) / 17.0f)) {
                i_renamed += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    private static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        if (com.google.zxing.pdf417.PDF417Common.getCodeword(bitValue) == -1) {
            return -1;
        }
        return bitValue;
    }

    private static int getBitValue(int[] iArr) {
        long j_renamed = 0;
        int i_renamed = 0;
        while (i_renamed < iArr.length) {
            long j2 = j_renamed;
            for (int i2 = 0; i2 < iArr[i_renamed]; i2++) {
                int i3 = 1;
                long j3 = j2 << 1;
                if (i_renamed % 2 != 0) {
                    i3 = 0;
                }
                j2 = j3 | i3;
            }
            i_renamed++;
            j_renamed = j2;
        }
        return (int) j_renamed;
    }

    private static int getClosestDecodedValue(int[] iArr) {
        int iSum = com.google.zxing.common.detector.MathUtils.sum(iArr);
        float[] fArr = new float[8];
        if (iSum > 1) {
            for (int i_renamed = 0; i_renamed < 8; i_renamed++) {
                fArr[i_renamed] = iArr[i_renamed] / iSum;
            }
        }
        int i2 = -1;
        float f_renamed = Float.MAX_VALUE;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float[] fArr3 = fArr2[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f_renamed) {
                    break;
                }
            }
            if (f2 < f_renamed) {
                i2 = com.google.zxing.pdf417.PDF417Common.SYMBOL_TABLE[i3];
                f_renamed = f2;
            }
            i3++;
        }
    }
}
