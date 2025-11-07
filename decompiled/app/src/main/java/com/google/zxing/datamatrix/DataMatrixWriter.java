package com.google.zxing.datamatrix;

/* loaded from: classes.dex */
public final class DataMatrixWriter implements com.google.zxing.Writer {
    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2) {
        return encode(str, barcodeFormat, i_renamed, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) {
        com.google.zxing.Dimension dimension;
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != com.google.zxing.BarcodeFormat.DATA_MATRIX) {
            throw new java.lang.IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        if (i_renamed < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Requested dimensions can't_renamed be_renamed negative: " + i_renamed + 'x_renamed' + i2);
        }
        com.google.zxing.datamatrix.encoder.SymbolShapeHint symbolShapeHint = com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_NONE;
        com.google.zxing.Dimension dimension2 = null;
        if (map != null) {
            com.google.zxing.datamatrix.encoder.SymbolShapeHint symbolShapeHint2 = (com.google.zxing.datamatrix.encoder.SymbolShapeHint) map.get(com.google.zxing.EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            dimension = (com.google.zxing.Dimension) map.get(com.google.zxing.EncodeHintType.MIN_SIZE);
            if (dimension == null) {
                dimension = null;
            }
            com.google.zxing.Dimension dimension3 = (com.google.zxing.Dimension) map.get(com.google.zxing.EncodeHintType.MAX_SIZE);
            if (dimension3 != null) {
                dimension2 = dimension3;
            }
        } else {
            dimension = null;
        }
        java.lang.String strEncodeHighLevel = com.google.zxing.datamatrix.encoder.HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension, dimension2);
        com.google.zxing.datamatrix.encoder.SymbolInfo symbolInfoLookup = com.google.zxing.datamatrix.encoder.SymbolInfo.lookup(strEncodeHighLevel.length(), symbolShapeHint, dimension, dimension2, true);
        com.google.zxing.datamatrix.encoder.DefaultPlacement defaultPlacement = new com.google.zxing.datamatrix.encoder.DefaultPlacement(com.google.zxing.datamatrix.encoder.ErrorCorrection.encodeECC200(strEncodeHighLevel, symbolInfoLookup), symbolInfoLookup.getSymbolDataWidth(), symbolInfoLookup.getSymbolDataHeight());
        defaultPlacement.place();
        return encodeLowLevel(defaultPlacement, symbolInfoLookup, i_renamed, i2);
    }

    private static com.google.zxing.common.BitMatrix encodeLowLevel(com.google.zxing.datamatrix.encoder.DefaultPlacement defaultPlacement, com.google.zxing.datamatrix.encoder.SymbolInfo symbolInfo, int i_renamed, int i2) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix = new com.google.zxing.qrcode.encoder.ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i3 = 0;
        for (int i4 = 0; i4 < symbolDataHeight; i4++) {
            if (i4 % symbolInfo.matrixHeight == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < symbolInfo.getSymbolWidth(); i6++) {
                    byteMatrix.set(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < symbolDataWidth; i8++) {
                if (i8 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i7, i3, true);
                    i7++;
                }
                byteMatrix.set(i7, i3, defaultPlacement.getBit(i8, i4));
                i7++;
                if (i8 % symbolInfo.matrixWidth == symbolInfo.matrixWidth - 1) {
                    byteMatrix.set(i7, i3, i4 % 2 == 0);
                    i7++;
                }
            }
            i3++;
            if (i4 % symbolInfo.matrixHeight == symbolInfo.matrixHeight - 1) {
                int i9 = 0;
                for (int i10 = 0; i10 < symbolInfo.getSymbolWidth(); i10++) {
                    byteMatrix.set(i9, i3, true);
                    i9++;
                }
                i3++;
            }
        }
        return convertByteMatrixToBitMatrix(byteMatrix, i_renamed, i2);
    }

    private static com.google.zxing.common.BitMatrix convertByteMatrixToBitMatrix(com.google.zxing.qrcode.encoder.ByteMatrix byteMatrix, int i_renamed, int i2) {
        com.google.zxing.common.BitMatrix bitMatrix;
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int iMax = java.lang.Math.max(i_renamed, width);
        int iMax2 = java.lang.Math.max(i2, height);
        int iMin = java.lang.Math.min(iMax / width, iMax2 / height);
        int i3 = (iMax - (width * iMin)) / 2;
        int i4 = (iMax2 - (height * iMin)) / 2;
        if (i2 < height || i_renamed < width) {
            bitMatrix = new com.google.zxing.common.BitMatrix(width, height);
            i3 = 0;
            i4 = 0;
        } else {
            bitMatrix = new com.google.zxing.common.BitMatrix(i_renamed, i2);
        }
        bitMatrix.clear();
        int i5 = 0;
        while (i5 < height) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < width) {
                if (byteMatrix.get(i7, i5) == 1) {
                    bitMatrix.setRegion(i6, i4, iMin, iMin);
                }
                i7++;
                i6 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return bitMatrix;
    }
}
