package com.google.zxing.common;

/* loaded from: classes.dex */
public class GlobalHistogramBinarizer extends com.google.zxing.Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets;
    private byte[] luminances;

    public GlobalHistogramBinarizer(com.google.zxing.LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    @Override // com.google.zxing.Binarizer
    public com.google.zxing.common.BitArray getBlackRow(int i_renamed, com.google.zxing.common.BitArray bitArray) throws com.google.zxing.NotFoundException {
        com.google.zxing.LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new com.google.zxing.common.BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i_renamed, this.luminances);
        int[] iArr = this.buckets;
        for (int i2 = 0; i2 < width; i2++) {
            int i3 = (row[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int iEstimateBlackPoint = estimateBlackPoint(iArr);
        if (width < 3) {
            for (int i4 = 0; i4 < width; i4++) {
                if ((row[i4] & 255) < iEstimateBlackPoint) {
                    bitArray.set(i4);
                }
            }
        } else {
            int i5 = row[0] & 255;
            int i6 = row[1] & 255;
            int i7 = i5;
            int i8 = 1;
            while (i8 < width - 1) {
                int i9 = i8 + 1;
                int i10 = row[i9] & 255;
                if ((((i6 << 2) - i7) - i10) / 2 < iEstimateBlackPoint) {
                    bitArray.set(i8);
                }
                i7 = i6;
                i8 = i9;
                i6 = i10;
            }
        }
        return bitArray;
    }

    @Override // com.google.zxing.Binarizer
    public com.google.zxing.common.BitMatrix getBlackMatrix() throws com.google.zxing.NotFoundException {
        com.google.zxing.LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i_renamed = 1; i_renamed < 5; i_renamed++) {
            byte[] row = luminanceSource.getRow((height * i_renamed) / 5, this.luminances);
            int i2 = (width << 2) / 5;
            for (int i3 = width / 5; i3 < i2; i3++) {
                int i4 = (row[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int iEstimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = i5 * width;
            for (int i7 = 0; i7 < width; i7++) {
                if ((matrix[i6 + i7] & 255) < iEstimateBlackPoint) {
                    bitMatrix.set(i7, i5);
                }
            }
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Binarizer
    public com.google.zxing.Binarizer createBinarizer(com.google.zxing.LuminanceSource luminanceSource) {
        return new com.google.zxing.common.GlobalHistogramBinarizer(luminanceSource);
    }

    private void initArrays(int i_renamed) {
        if (this.luminances.length < i_renamed) {
            this.luminances = new byte[i_renamed];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.buckets[i2] = 0;
        }
    }

    private static int estimateBlackPoint(int[] iArr) throws com.google.zxing.NotFoundException {
        int length = iArr.length;
        int i_renamed = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] > i_renamed) {
                i_renamed = iArr[i4];
                i3 = i4;
            }
            if (iArr[i4] > i2) {
                i2 = iArr[i4];
            }
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = i7 - i3;
            int i9 = iArr[i7] * i8 * i8;
            if (i9 > i6) {
                i5 = i7;
                i6 = i9;
            }
        }
        if (i3 > i5) {
            int i10 = i3;
            i3 = i5;
            i5 = i10;
        }
        if (i5 - i3 <= length / 16) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i11 = i5 - 1;
        int i12 = -1;
        int i13 = i11;
        while (i11 > i3) {
            int i14 = i11 - i3;
            int i15 = i14 * i14 * (i5 - i11) * (i2 - iArr[i11]);
            if (i15 > i12) {
                i13 = i11;
                i12 = i15;
            }
            i11--;
        }
        return i13 << 3;
    }
}
