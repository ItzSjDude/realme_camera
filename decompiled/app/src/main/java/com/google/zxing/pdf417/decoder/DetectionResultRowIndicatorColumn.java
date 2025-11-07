package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
final class DetectionResultRowIndicatorColumn extends com.google.zxing.pdf417.decoder.DetectionResultColumn {
    private final boolean isLeft;

    DetectionResultRowIndicatorColumn(com.google.zxing.pdf417.decoder.BoundingBox boundingBox, boolean z_renamed) {
        super(boundingBox);
        this.isLeft = z_renamed;
    }

    private void setRowNumbers() {
        for (com.google.zxing.pdf417.decoder.Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    void adjustCompleteIndicatorColumnRowNumbers(com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata) {
        com.google.zxing.pdf417.decoder.Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        com.google.zxing.pdf417.decoder.BoundingBox boundingBox = getBoundingBox();
        com.google.zxing.ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        com.google.zxing.ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int iImageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int iImageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        int rowNumber = -1;
        int i_renamed = 0;
        int iMax = 1;
        while (iImageRowToCodewordIndex < iImageRowToCodewordIndex2) {
            if (codewords[iImageRowToCodewordIndex] != null) {
                com.google.zxing.pdf417.decoder.Codeword codeword = codewords[iImageRowToCodewordIndex];
                int rowNumber2 = codeword.getRowNumber() - rowNumber;
                if (rowNumber2 == 0) {
                    i_renamed++;
                } else {
                    if (rowNumber2 == 1) {
                        iMax = java.lang.Math.max(iMax, i_renamed);
                        rowNumber = codeword.getRowNumber();
                    } else if (rowNumber2 < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber2 > iImageRowToCodewordIndex) {
                        codewords[iImageRowToCodewordIndex] = null;
                    } else {
                        if (iMax > 2) {
                            rowNumber2 *= iMax - 2;
                        }
                        boolean z_renamed = rowNumber2 >= iImageRowToCodewordIndex;
                        for (int i2 = 1; i2 <= rowNumber2 && !z_renamed; i2++) {
                            z_renamed = codewords[iImageRowToCodewordIndex - i2] != null;
                        }
                        if (z_renamed) {
                            codewords[iImageRowToCodewordIndex] = null;
                        } else {
                            rowNumber = codeword.getRowNumber();
                        }
                    }
                    i_renamed = 1;
                }
            }
            iImageRowToCodewordIndex++;
        }
    }

    int[] getRowHeights() {
        int rowNumber;
        com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int[] iArr = new int[barcodeMetadata.getRowCount()];
        for (com.google.zxing.pdf417.decoder.Codeword codeword : getCodewords()) {
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < iArr.length) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
        }
        return iArr;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata) {
        com.google.zxing.pdf417.decoder.BoundingBox boundingBox = getBoundingBox();
        com.google.zxing.ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        com.google.zxing.ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int iImageRowToCodewordIndex = imageRowToCodewordIndex((int) bottomLeft.getY());
        com.google.zxing.pdf417.decoder.Codeword[] codewords = getCodewords();
        int rowNumber = -1;
        int i_renamed = 0;
        int iMax = 1;
        for (int iImageRowToCodewordIndex2 = imageRowToCodewordIndex((int) topLeft.getY()); iImageRowToCodewordIndex2 < iImageRowToCodewordIndex; iImageRowToCodewordIndex2++) {
            if (codewords[iImageRowToCodewordIndex2] != null) {
                com.google.zxing.pdf417.decoder.Codeword codeword = codewords[iImageRowToCodewordIndex2];
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber2 = codeword.getRowNumber() - rowNumber;
                if (rowNumber2 == 0) {
                    i_renamed++;
                } else {
                    if (rowNumber2 == 1) {
                        iMax = java.lang.Math.max(iMax, i_renamed);
                        rowNumber = codeword.getRowNumber();
                    } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                        codewords[iImageRowToCodewordIndex2] = null;
                    } else {
                        rowNumber = codeword.getRowNumber();
                    }
                    i_renamed = 1;
                }
            }
        }
    }

    com.google.zxing.pdf417.decoder.BarcodeMetadata getBarcodeMetadata() {
        com.google.zxing.pdf417.decoder.Codeword[] codewords = getCodewords();
        com.google.zxing.pdf417.decoder.BarcodeValue barcodeValue = new com.google.zxing.pdf417.decoder.BarcodeValue();
        com.google.zxing.pdf417.decoder.BarcodeValue barcodeValue2 = new com.google.zxing.pdf417.decoder.BarcodeValue();
        com.google.zxing.pdf417.decoder.BarcodeValue barcodeValue3 = new com.google.zxing.pdf417.decoder.BarcodeValue();
        com.google.zxing.pdf417.decoder.BarcodeValue barcodeValue4 = new com.google.zxing.pdf417.decoder.BarcodeValue();
        for (com.google.zxing.pdf417.decoder.Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                int i_renamed = rowNumber % 3;
                if (i_renamed == 0) {
                    barcodeValue2.setValue((value * 3) + 1);
                } else if (i_renamed == 1) {
                    barcodeValue4.setValue(value / 3);
                    barcodeValue3.setValue(value % 3);
                } else if (i_renamed == 2) {
                    barcodeValue.setValue(value + 1);
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata = new com.google.zxing.pdf417.decoder.BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    private void removeIncorrectCodewords(com.google.zxing.pdf417.decoder.Codeword[] codewordArr, com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata) {
        for (int i_renamed = 0; i_renamed < codewordArr.length; i_renamed++) {
            com.google.zxing.pdf417.decoder.Codeword codeword = codewordArr[i_renamed];
            if (codewordArr[i_renamed] != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i_renamed] = null;
                } else {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    int i2 = rowNumber % 3;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                                codewordArr[i_renamed] = null;
                            }
                        } else if (i2 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                            codewordArr[i_renamed] = null;
                        }
                    } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                        codewordArr[i_renamed] = null;
                    }
                }
            }
        }
    }

    boolean isLeft() {
        return this.isLeft;
    }

    @Override // com.google.zxing.pdf417.decoder.DetectionResultColumn
    public java.lang.String toString() {
        return "IsLeft: " + this.isLeft + '\n_renamed' + super.toString();
    }
}
