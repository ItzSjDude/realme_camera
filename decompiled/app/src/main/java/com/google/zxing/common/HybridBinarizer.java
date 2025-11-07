package com.google.zxing.common;

/* loaded from: classes.dex */
public final class HybridBinarizer extends com.google.zxing.common.GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private com.google.zxing.common.BitMatrix matrix;

    private static int cap(int i_renamed, int i2) {
        if (i_renamed < 2) {
            return 2;
        }
        return i_renamed > i2 ? i2 : i_renamed;
    }

    public HybridBinarizer(com.google.zxing.LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public com.google.zxing.common.BitMatrix getBlackMatrix() throws com.google.zxing.NotFoundException {
        com.google.zxing.common.BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        com.google.zxing.LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width >= 40 && height >= 40) {
            byte[] matrix = luminanceSource.getMatrix();
            int i_renamed = width >> 3;
            if ((width & 7) != 0) {
                i_renamed++;
            }
            int i2 = i_renamed;
            int i3 = height >> 3;
            if ((height & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] iArrCalculateBlackPoints = calculateBlackPoints(matrix, i2, i4, width, height);
            com.google.zxing.common.BitMatrix bitMatrix2 = new com.google.zxing.common.BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i2, i4, width, height, iArrCalculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        } else {
            this.matrix = super.getBlackMatrix();
        }
        return this.matrix;
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public com.google.zxing.Binarizer createBinarizer(com.google.zxing.LuminanceSource luminanceSource) {
        return new com.google.zxing.common.HybridBinarizer(luminanceSource);
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i_renamed, int i2, int i3, int i4, int[][] iArr, com.google.zxing.common.BitMatrix bitMatrix) {
        int i5 = i4 - 8;
        int i6 = i3 - 8;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 << 3;
            int i9 = i8 > i5 ? i5 : i8;
            int iCap = cap(i7, i2 - 3);
            for (int i10 = 0; i10 < i_renamed; i10++) {
                int i11 = i10 << 3;
                int i12 = i11 > i6 ? i6 : i11;
                int iCap2 = cap(i10, i_renamed - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[iCap + i14];
                    i13 += iArr2[iCap2 - 2] + iArr2[iCap2 - 1] + iArr2[iCap2] + iArr2[iCap2 + 1] + iArr2[2 + iCap2];
                }
                thresholdBlock(bArr, i12, i9, i13 / 25, i3, bitMatrix);
            }
        }
    }

    private static void thresholdBlock(byte[] bArr, int i_renamed, int i2, int i3, int i4, com.google.zxing.common.BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i_renamed;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bitMatrix.set(i_renamed + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i_renamed, int i2, int i3, int i4) {
        int i5 = 8;
        int i6 = i4 - 8;
        int i7 = i3 - 8;
        int[][] iArr = (int[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) int.class, i2, i_renamed);
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = i8 << 3;
            if (i9 > i6) {
                i9 = i6;
            }
            for (int i10 = 0; i10 < i_renamed; i10++) {
                int i11 = i10 << 3;
                if (i11 > i7) {
                    i11 = i7;
                }
                int i12 = 255;
                int i13 = (i9 * i3) + i11;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                while (i14 < i5) {
                    int i17 = i15;
                    int i18 = 0;
                    while (i18 < i5) {
                        int i19 = bArr[i13 + i18] & 255;
                        i17 += i19;
                        if (i19 < i12) {
                            i12 = i19;
                        }
                        if (i19 > i16) {
                            i16 = i19;
                        }
                        i18++;
                        i5 = 8;
                    }
                    if (i16 - i12 > 24) {
                        i14++;
                        i13 += i3;
                        i5 = 8;
                        while (i14 < 8) {
                            for (int i20 = 0; i20 < 8; i20++) {
                                i17 += bArr[i13 + i20] & 255;
                            }
                            i14++;
                            i13 += i3;
                        }
                    } else {
                        i5 = 8;
                    }
                    i15 = i17;
                    i14++;
                    i13 += i3;
                }
                int i21 = i15 >> 6;
                if (i16 - i12 <= 24) {
                    i21 = i12 / 2;
                    if (i8 > 0 && i10 > 0) {
                        int i22 = i8 - 1;
                        int i23 = i10 - 1;
                        int i24 = ((iArr[i22][i10] + (iArr[i8][i23] * 2)) + iArr[i22][i23]) / 4;
                        if (i12 < i24) {
                            i21 = i24;
                        }
                    }
                }
                iArr[i8][i10] = i21;
            }
        }
        return iArr;
    }
}
