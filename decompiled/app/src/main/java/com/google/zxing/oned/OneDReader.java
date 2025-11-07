package com.google.zxing.oned;

/* loaded from: classes.dex */
public abstract class OneDReader implements com.google.zxing.Reader {
    public abstract com.google.zxing.Result decodeRow(int i_renamed, com.google.zxing.common.BitArray bitArray, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException;

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (com.google.zxing.NotFoundException e_renamed) {
            if ((map != null && map.containsKey(com.google.zxing.DecodeHintType.TRY_HARDER)) && binaryBitmap.isRotateSupported()) {
                com.google.zxing.BinaryBitmap binaryBitmapRotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
                com.google.zxing.Result resultDoDecode = this.doDecode(binaryBitmapRotateCounterClockwise, map);
                java.util.Map<com.google.zxing.ResultMetadataType, java.lang.Object> resultMetadata = resultDoDecode.getResultMetadata();
                int iIntValue = 270;
                if (resultMetadata != null && resultMetadata.containsKey(com.google.zxing.ResultMetadataType.ORIENTATION)) {
                    iIntValue = (((java.lang.Integer) resultMetadata.get(com.google.zxing.ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
                }
                resultDoDecode.putMetadata(com.google.zxing.ResultMetadataType.ORIENTATION, java.lang.Integer.valueOf(iIntValue));
                com.google.zxing.ResultPoint[] resultPoints = resultDoDecode.getResultPoints();
                if (resultPoints != null) {
                    int height = binaryBitmapRotateCounterClockwise.getHeight();
                    for (int i_renamed = 0; i_renamed < resultPoints.length; i_renamed++) {
                        resultPoints[i_renamed] = new com.google.zxing.ResultPoint((height - resultPoints[i_renamed].getY()) - 1.0f, resultPoints[i_renamed].getX());
                    }
                }
                return resultDoDecode;
            }
            throw e_renamed;
        }
    }

    private com.google.zxing.Result doDecode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        int i_renamed;
        int i2;
        int i3;
        int i4;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        com.google.zxing.common.BitArray bitArray = new com.google.zxing.common.BitArray(width);
        int i5 = 0;
        int i6 = 1;
        boolean z_renamed = map != null && map.containsKey(com.google.zxing.DecodeHintType.TRY_HARDER);
        int iMax = java.lang.Math.max(1, height >> (z_renamed ? 8 : 5));
        int i7 = z_renamed ? height : 15;
        int i8 = height / 2;
        java.util.Map<com.google.zxing.DecodeHintType, ?> map2 = map;
        int i9 = 0;
        while (i9 < i7) {
            int i10 = i9 + 1;
            int i11 = i10 / 2;
            if (((i9 & 1) == 0 ? i6 : i5) == 0) {
                i11 = -i11;
            }
            int i12 = (i11 * iMax) + i8;
            if (i12 < 0 || i12 >= height) {
                break;
            }
            try {
                bitArray = binaryBitmap.getBlackRow(i12, bitArray);
                java.util.Map<com.google.zxing.DecodeHintType, ?> map3 = map2;
                int i13 = i5;
                while (i13 < 2) {
                    if (i13 == i6) {
                        bitArray.reverse();
                        if (map3 != null && map3.containsKey(com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                            java.util.EnumMap enumMap = new java.util.EnumMap(com.google.zxing.DecodeHintType.class);
                            enumMap.putAll(map3);
                            enumMap.remove(com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                            map3 = enumMap;
                        }
                    }
                    try {
                        com.google.zxing.Result resultDecodeRow = decodeRow(i12, bitArray, map3);
                        if (i13 == i6) {
                            try {
                                resultDecodeRow.putMetadata(com.google.zxing.ResultMetadataType.ORIENTATION, 180);
                                com.google.zxing.ResultPoint[] resultPoints = resultDecodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    float f_renamed = width;
                                    i3 = width;
                                    try {
                                        resultPoints[0] = new com.google.zxing.ResultPoint((f_renamed - resultPoints[i5].getX()) - 1.0f, resultPoints[i5].getY());
                                        i4 = 1;
                                    } catch (com.google.zxing.ReaderException unused) {
                                        i4 = 1;
                                        i13++;
                                        i6 = i4;
                                        width = i3;
                                        i5 = 0;
                                    }
                                    try {
                                        resultPoints[1] = new com.google.zxing.ResultPoint((f_renamed - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                    } catch (com.google.zxing.ReaderException unused2) {
                                        continue;
                                        i13++;
                                        i6 = i4;
                                        width = i3;
                                        i5 = 0;
                                    }
                                }
                            } catch (com.google.zxing.ReaderException unused3) {
                                i3 = width;
                            }
                        }
                        return resultDecodeRow;
                    } catch (com.google.zxing.ReaderException unused4) {
                        i3 = width;
                        i4 = i6;
                    }
                }
                i_renamed = width;
                i2 = i6;
                map2 = map3;
            } catch (com.google.zxing.NotFoundException unused5) {
                i_renamed = width;
                i2 = i6;
            }
            i9 = i10;
            i6 = i2;
            width = i_renamed;
            i5 = 0;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }

    protected static void recordPattern(com.google.zxing.common.BitArray bitArray, int i_renamed, int[] iArr) throws com.google.zxing.NotFoundException {
        int length = iArr.length;
        java.util.Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i_renamed >= size) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        boolean z_renamed = !bitArray.get(i_renamed);
        int i2 = 0;
        while (i_renamed < size) {
            if (bitArray.get(i_renamed) == z_renamed) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z_renamed = !z_renamed;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i_renamed++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i_renamed != size) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void recordPatternInReverse(com.google.zxing.common.BitArray bitArray, int i_renamed, int[] iArr) throws com.google.zxing.NotFoundException {
        int length = iArr.length;
        boolean z_renamed = bitArray.get(i_renamed);
        while (i_renamed > 0 && length >= 0) {
            i_renamed--;
            if (bitArray.get(i_renamed) != z_renamed) {
                length--;
                z_renamed = !z_renamed;
            }
        }
        if (length >= 0) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i_renamed + 1, iArr);
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float f_renamed) {
        int length = iArr.length;
        int i_renamed = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i_renamed += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i_renamed < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i_renamed;
        float f3 = f2 / i2;
        float f4 = f_renamed * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
