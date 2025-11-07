package com.google.zxing.pdf417;

/* loaded from: classes.dex */
public final class PDF417Writer implements com.google.zxing.Writer {
    private static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    private static final int WHITE_SPACE = 30;

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.PDF_417) {
            throw new java.lang.IllegalArgumentException("Can only encode PDF_417, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        com.google.zxing.pdf417.encoder.PDF417 pdf417 = new com.google.zxing.pdf417.encoder.PDF417();
        if (map != null) {
            if (map.containsKey(com.google.zxing.EncodeHintType.PDF417_COMPACT)) {
                pdf417.setCompact(java.lang.Boolean.valueOf(map.get(com.google.zxing.EncodeHintType.PDF417_COMPACT).toString()).booleanValue());
            }
            if (map.containsKey(com.google.zxing.EncodeHintType.PDF417_COMPACTION)) {
                pdf417.setCompaction(com.google.zxing.pdf417.encoder.Compaction.valueOf(map.get(com.google.zxing.EncodeHintType.PDF417_COMPACTION).toString()));
            }
            if (map.containsKey(com.google.zxing.EncodeHintType.PDF417_DIMENSIONS)) {
                com.google.zxing.pdf417.encoder.Dimensions dimensions = (com.google.zxing.pdf417.encoder.Dimensions) map.get(com.google.zxing.EncodeHintType.PDF417_DIMENSIONS);
                pdf417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
            }
            i_renamed = map.containsKey(com.google.zxing.EncodeHintType.MARGIN) ? java.lang.Integer.parseInt(map.get(com.google.zxing.EncodeHintType.MARGIN).toString()) : 30;
            i_renamed = map.containsKey(com.google.zxing.EncodeHintType.ERROR_CORRECTION) ? java.lang.Integer.parseInt(map.get(com.google.zxing.EncodeHintType.ERROR_CORRECTION).toString()) : 2;
            if (map.containsKey(com.google.zxing.EncodeHintType.CHARACTER_SET)) {
                pdf417.setEncoding(java.nio.charset.Charset.forName(map.get(com.google.zxing.EncodeHintType.CHARACTER_SET).toString()));
            }
        }
        return bitMatrixFromEncoder(pdf417, str, i_renamed, i_renamed, i2, i_renamed);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2) throws com.google.zxing.WriterException {
        return encode(str, barcodeFormat, i_renamed, i2, null);
    }

    private static com.google.zxing.common.BitMatrix bitMatrixFromEncoder(com.google.zxing.pdf417.encoder.PDF417 pdf417, java.lang.String str, int i_renamed, int i2, int i3, int i4) throws com.google.zxing.WriterException {
        boolean z_renamed;
        pdf417.generateBarcodeLogic(str, i_renamed);
        byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
        if ((i3 > i2) != (scaledMatrix[0].length < scaledMatrix.length)) {
            scaledMatrix = rotateArray(scaledMatrix);
            z_renamed = true;
        } else {
            z_renamed = false;
        }
        int length = i2 / scaledMatrix[0].length;
        int length2 = i3 / scaledMatrix.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length, length << 2);
            if (z_renamed) {
                scaledMatrix2 = rotateArray(scaledMatrix2);
            }
            return bitMatrixFromBitArray(scaledMatrix2, i4);
        }
        return bitMatrixFromBitArray(scaledMatrix, i4);
    }

    private static com.google.zxing.common.BitMatrix bitMatrixFromBitArray(byte[][] bArr, int i_renamed) {
        int i2 = i_renamed * 2;
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(bArr[0].length + i2, bArr.length + i2);
        bitMatrix.clear();
        int height = (bitMatrix.getHeight() - i_renamed) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    bitMatrix.set(i4 + i_renamed, height);
                }
            }
            i3++;
            height--;
        }
        return bitMatrix;
    }

    private static byte[][] rotateArray(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            int length = (bArr.length - i_renamed) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i_renamed][i2];
            }
        }
        return bArr2;
    }
}
