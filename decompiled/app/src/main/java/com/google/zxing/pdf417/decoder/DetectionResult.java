package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata;
    private com.google.zxing.pdf417.decoder.BoundingBox boundingBox;
    private final com.google.zxing.pdf417.decoder.DetectionResultColumn[] detectionResultColumns;

    DetectionResult(com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata, com.google.zxing.pdf417.decoder.BoundingBox boundingBox) {
        this.barcodeMetadata = barcodeMetadata;
        this.barcodeColumnCount = barcodeMetadata.getColumnCount();
        this.boundingBox = boundingBox;
        this.detectionResultColumns = new com.google.zxing.pdf417.decoder.DetectionResultColumn[this.barcodeColumnCount + 2];
    }

    com.google.zxing.pdf417.decoder.DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int i_renamed = com.google.zxing.pdf417.PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        while (true) {
            int iAdjustRowNumbers = adjustRowNumbers();
            if (iAdjustRowNumbers <= 0 || iAdjustRowNumbers >= i_renamed) {
                break;
            }
            i_renamed = iAdjustRowNumbers;
        }
        return this.detectionResultColumns;
    }

    private void adjustIndicatorColumnRowNumbers(com.google.zxing.pdf417.decoder.DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private int adjustRowNumbers() {
        int iAdjustRowNumbersByRow = adjustRowNumbersByRow();
        if (iAdjustRowNumbersByRow == 0) {
            return 0;
        }
        for (int i_renamed = 1; i_renamed < this.barcodeColumnCount + 1; i_renamed++) {
            com.google.zxing.pdf417.decoder.Codeword[] codewords = this.detectionResultColumns[i_renamed].getCodewords();
            for (int i2 = 0; i2 < codewords.length; i2++) {
                if (codewords[i2] != null && !codewords[i2].hasValidRowNumber()) {
                    adjustRowNumbers(i_renamed, i2, codewords);
                }
            }
        }
        return iAdjustRowNumbersByRow;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        com.google.zxing.pdf417.decoder.DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[0] == null || detectionResultColumnArr[this.barcodeColumnCount + 1] == null) {
            return;
        }
        com.google.zxing.pdf417.decoder.Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
        com.google.zxing.pdf417.decoder.Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
        for (int i_renamed = 0; i_renamed < codewords.length; i_renamed++) {
            if (codewords[i_renamed] != null && codewords2[i_renamed] != null && codewords[i_renamed].getRowNumber() == codewords2[i_renamed].getRowNumber()) {
                for (int i2 = 1; i2 <= this.barcodeColumnCount; i2++) {
                    com.google.zxing.pdf417.decoder.Codeword codeword = this.detectionResultColumns[i2].getCodewords()[i_renamed];
                    if (codeword != null) {
                        codeword.setRowNumber(codewords[i_renamed].getRowNumber());
                        if (!codeword.hasValidRowNumber()) {
                            this.detectionResultColumns[i2].getCodewords()[i_renamed] = null;
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromRRI() {
        com.google.zxing.pdf417.decoder.DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i_renamed = this.barcodeColumnCount;
        if (detectionResultColumnArr[i_renamed + 1] == null) {
            return 0;
        }
        com.google.zxing.pdf417.decoder.Codeword[] codewords = detectionResultColumnArr[i_renamed + 1].getCodewords();
        int i2 = 0;
        for (int i3 = 0; i3 < codewords.length; i3++) {
            if (codewords[i3] != null) {
                int rowNumber = codewords[i3].getRowNumber();
                int i4 = i2;
                int iAdjustRowNumberIfValid = 0;
                for (int i5 = this.barcodeColumnCount + 1; i5 > 0 && iAdjustRowNumberIfValid < 2; i5--) {
                    com.google.zxing.pdf417.decoder.Codeword codeword = this.detectionResultColumns[i5].getCodewords()[i3];
                    if (codeword != null) {
                        iAdjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, iAdjustRowNumberIfValid, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            i4++;
                        }
                    }
                }
                i2 = i4;
            }
        }
        return i2;
    }

    private int adjustRowNumbersFromLRI() {
        com.google.zxing.pdf417.decoder.DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[0] == null) {
            return 0;
        }
        com.google.zxing.pdf417.decoder.Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
        int i_renamed = 0;
        for (int i2 = 0; i2 < codewords.length; i2++) {
            if (codewords[i2] != null) {
                int rowNumber = codewords[i2].getRowNumber();
                int iAdjustRowNumberIfValid = 0;
                int i3 = i_renamed;
                for (int i4 = 1; i4 < this.barcodeColumnCount + 1 && iAdjustRowNumberIfValid < 2; i4++) {
                    com.google.zxing.pdf417.decoder.Codeword codeword = this.detectionResultColumns[i4].getCodewords()[i2];
                    if (codeword != null) {
                        iAdjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, iAdjustRowNumberIfValid, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            i3++;
                        }
                    }
                }
                i_renamed = i3;
            }
        }
        return i_renamed;
    }

    private static int adjustRowNumberIfValid(int i_renamed, int i2, com.google.zxing.pdf417.decoder.Codeword codeword) {
        if (codeword == null || codeword.hasValidRowNumber()) {
            return i2;
        }
        if (!codeword.isValidRowNumber(i_renamed)) {
            return i2 + 1;
        }
        codeword.setRowNumber(i_renamed);
        return 0;
    }

    private void adjustRowNumbers(int i_renamed, int i2, com.google.zxing.pdf417.decoder.Codeword[] codewordArr) {
        com.google.zxing.pdf417.decoder.Codeword codeword = codewordArr[i2];
        com.google.zxing.pdf417.decoder.Codeword[] codewords = this.detectionResultColumns[i_renamed - 1].getCodewords();
        com.google.zxing.pdf417.decoder.DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i3 = i_renamed + 1;
        com.google.zxing.pdf417.decoder.Codeword[] codewords2 = detectionResultColumnArr[i3] != null ? detectionResultColumnArr[i3].getCodewords() : codewords;
        com.google.zxing.pdf417.decoder.Codeword[] codewordArr2 = new com.google.zxing.pdf417.decoder.Codeword[14];
        codewordArr2[2] = codewords[i2];
        codewordArr2[3] = codewords2[i2];
        if (i2 > 0) {
            int i4 = i2 - 1;
            codewordArr2[0] = codewordArr[i4];
            codewordArr2[4] = codewords[i4];
            codewordArr2[5] = codewords2[i4];
        }
        if (i2 > 1) {
            int i5 = i2 - 2;
            codewordArr2[8] = codewordArr[i5];
            codewordArr2[10] = codewords[i5];
            codewordArr2[11] = codewords2[i5];
        }
        if (i2 < codewordArr.length - 1) {
            int i6 = i2 + 1;
            codewordArr2[1] = codewordArr[i6];
            codewordArr2[6] = codewords[i6];
            codewordArr2[7] = codewords2[i6];
        }
        if (i2 < codewordArr.length - 2) {
            int i7 = i2 + 2;
            codewordArr2[9] = codewordArr[i7];
            codewordArr2[12] = codewords[i7];
            codewordArr2[13] = codewords2[i7];
        }
        for (int i8 = 0; i8 < 14 && !adjustRowNumber(codeword, codewordArr2[i8]); i8++) {
        }
    }

    private static boolean adjustRowNumber(com.google.zxing.pdf417.decoder.Codeword codeword, com.google.zxing.pdf417.decoder.Codeword codeword2) {
        if (codeword2 == null || !codeword2.hasValidRowNumber() || codeword2.getBucket() != codeword.getBucket()) {
            return false;
        }
        codeword.setRowNumber(codeword2.getRowNumber());
        return true;
    }

    int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    void setBoundingBox(com.google.zxing.pdf417.decoder.BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    com.google.zxing.pdf417.decoder.BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    void setDetectionResultColumn(int i_renamed, com.google.zxing.pdf417.decoder.DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[i_renamed] = detectionResultColumn;
    }

    com.google.zxing.pdf417.decoder.DetectionResultColumn getDetectionResultColumn(int i_renamed) {
        return this.detectionResultColumns[i_renamed];
    }

    public java.lang.String toString() {
        com.google.zxing.pdf417.decoder.DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        com.google.zxing.pdf417.decoder.DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.barcodeColumnCount + 1];
        }
        java.util.Formatter formatter = new java.util.Formatter();
        java.lang.Throwable th = null;
        for (int i_renamed = 0; i_renamed < detectionResultColumn.getCodewords().length; i_renamed++) {
            try {
                try {
                    formatter.format("CW %3d:", java.lang.Integer.valueOf(i_renamed));
                    for (int i2 = 0; i2 < this.barcodeColumnCount + 2; i2++) {
                        if (this.detectionResultColumns[i2] == null) {
                            formatter.format("    |   ", new java.lang.Object[0]);
                        } else {
                            com.google.zxing.pdf417.decoder.Codeword codeword = this.detectionResultColumns[i2].getCodewords()[i_renamed];
                            if (codeword == null) {
                                formatter.format("    |   ", new java.lang.Object[0]);
                            } else {
                                formatter.format(" %3d|%3d", java.lang.Integer.valueOf(codeword.getRowNumber()), java.lang.Integer.valueOf(codeword.getValue()));
                            }
                        }
                    }
                    formatter.format("%n_renamed", new java.lang.Object[0]);
                } finally {
                }
            } catch (java.lang.Throwable th2) {
                if (th != null) {
                    try {
                        formatter.close();
                    } catch (java.lang.Throwable th3) {
                        th.addSuppressed(th3);
                    }
                } else {
                    formatter.close();
                }
                throw th2;
            }
        }
        java.lang.String string = formatter.toString();
        formatter.close();
        return string;
    }
}
