package com.google.zxing.pdf417.decoder;

/* loaded from: classes.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final com.google.zxing.pdf417.decoder.ec_renamed.ErrorCorrection errorCorrection = new com.google.zxing.pdf417.decoder.ec_renamed.ErrorCorrection();

    private static boolean checkCodewordSkew(int i_renamed, int i2, int i3) {
        return i2 + (-2) <= i_renamed && i_renamed <= i3 + 2;
    }

    private static int getNumberOfECCodeWords(int i_renamed) {
        return 2 << i_renamed;
    }

    private PDF417ScanningDecoder() {
    }

    public static com.google.zxing.common.DecoderResult decode(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2, com.google.zxing.ResultPoint resultPoint3, com.google.zxing.ResultPoint resultPoint4, int i_renamed, int i2) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn;
        com.google.zxing.pdf417.decoder.DetectionResult detectionResultMerge;
        com.google.zxing.pdf417.decoder.DetectionResultColumn detectionResultRowIndicatorColumn2;
        int i3;
        int i4;
        int i5;
        com.google.zxing.pdf417.decoder.DetectionResultColumn detectionResultColumn;
        int i6;
        boolean z_renamed = false;
        com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn rowIndicatorColumn = null;
        com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn rowIndicatorColumn2 = null;
        boolean z2 = true;
        com.google.zxing.pdf417.decoder.BoundingBox boundingBox = new com.google.zxing.pdf417.decoder.BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        while (true) {
            if (resultPoint != null) {
                rowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i_renamed, i2);
            }
            detectionResultRowIndicatorColumn = rowIndicatorColumn;
            if (resultPoint3 != null) {
                rowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i_renamed, i2);
            }
            detectionResultMerge = merge(detectionResultRowIndicatorColumn, rowIndicatorColumn2);
            if (detectionResultMerge == null) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            com.google.zxing.pdf417.decoder.BoundingBox boundingBox2 = detectionResultMerge.getBoundingBox();
            if (!z2 || boundingBox2 == null || (boundingBox2.getMinY() >= boundingBox.getMinY() && boundingBox2.getMaxY() <= boundingBox.getMaxY())) {
                break;
            }
            z2 = false;
            boundingBox = boundingBox2;
            rowIndicatorColumn = detectionResultRowIndicatorColumn;
        }
        detectionResultMerge.setBoundingBox(boundingBox);
        int barcodeColumnCount = detectionResultMerge.getBarcodeColumnCount() + 1;
        detectionResultMerge.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        detectionResultMerge.setDetectionResultColumn(barcodeColumnCount, rowIndicatorColumn2);
        boolean z3 = detectionResultRowIndicatorColumn != null;
        int i7 = i_renamed;
        int i8 = i2;
        int i9 = 1;
        while (i9 <= barcodeColumnCount) {
            int i10 = z3 ? i9 : barcodeColumnCount - i9;
            if (detectionResultMerge.getDetectionResultColumn(i10) == null) {
                if (i10 == 0 || i10 == barcodeColumnCount) {
                    detectionResultRowIndicatorColumn2 = new com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn(boundingBox, i10 == 0 ? true : z_renamed);
                } else {
                    detectionResultRowIndicatorColumn2 = new com.google.zxing.pdf417.decoder.DetectionResultColumn(boundingBox);
                }
                com.google.zxing.pdf417.decoder.DetectionResultColumn detectionResultColumn2 = detectionResultRowIndicatorColumn2;
                detectionResultMerge.setDetectionResultColumn(i10, detectionResultColumn2);
                int i11 = -1;
                int iMax = i8;
                int i12 = -1;
                int iMin = i7;
                int minY = boundingBox.getMinY();
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResultMerge, i10, minY, z3);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i6 = startColumn;
                    } else if (i12 != i11) {
                        i6 = i12;
                    } else {
                        i3 = i12;
                        i4 = iMax;
                        i5 = i11;
                        detectionResultColumn = detectionResultColumn2;
                        iMax = i4;
                        i12 = i3;
                        minY++;
                        detectionResultColumn2 = detectionResultColumn;
                        i11 = i5;
                    }
                    i3 = i12;
                    int i13 = iMax;
                    i5 = i11;
                    detectionResultColumn = detectionResultColumn2;
                    com.google.zxing.pdf417.decoder.Codeword codewordDetectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z3, i6, minY, iMin, i13);
                    if (codewordDetectCodeword != null) {
                        detectionResultColumn.setCodeword(minY, codewordDetectCodeword);
                        iMin = java.lang.Math.min(iMin, codewordDetectCodeword.getWidth());
                        iMax = java.lang.Math.max(i13, codewordDetectCodeword.getWidth());
                        i12 = i6;
                        minY++;
                        detectionResultColumn2 = detectionResultColumn;
                        i11 = i5;
                    } else {
                        i4 = i13;
                        iMax = i4;
                        i12 = i3;
                        minY++;
                        detectionResultColumn2 = detectionResultColumn;
                        i11 = i5;
                    }
                }
                i7 = iMin;
                i8 = iMax;
            }
            i9++;
            z_renamed = false;
        }
        return createDecoderResult(detectionResultMerge);
    }

    private static com.google.zxing.pdf417.decoder.DetectionResult merge(com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws com.google.zxing.NotFoundException {
        com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new com.google.zxing.pdf417.decoder.DetectionResult(barcodeMetadata, com.google.zxing.pdf417.decoder.BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    private static com.google.zxing.pdf417.decoder.BoundingBox adjustBoundingBox(com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws com.google.zxing.NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i_renamed = 0;
        int i2 = 0;
        for (int i3 : rowHeights) {
            i2 += max - i3;
            if (i3 > 0) {
                break;
            }
        }
        com.google.zxing.pdf417.decoder.Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        for (int i4 = 0; i2 > 0 && codewords[i4] == null; i4++) {
            i2--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i_renamed += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i_renamed > 0 && codewords[length2] == null; length2--) {
            i_renamed--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i2, i_renamed, detectionResultRowIndicatorColumn.isLeft());
    }

    private static int getMax(int[] iArr) {
        int iMax = -1;
        for (int i_renamed : iArr) {
            iMax = java.lang.Math.max(iMax, i_renamed);
        }
        return iMax;
    }

    private static com.google.zxing.pdf417.decoder.BarcodeMetadata getBarcodeMetadata(com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata;
        com.google.zxing.pdf417.decoder.BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        }
        return null;
    }

    private static com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn getRowIndicatorColumn(com.google.zxing.common.BitMatrix bitMatrix, com.google.zxing.pdf417.decoder.BoundingBox boundingBox, com.google.zxing.ResultPoint resultPoint, boolean z_renamed, int i_renamed, int i2) {
        com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new com.google.zxing.pdf417.decoder.DetectionResultRowIndicatorColumn(boundingBox, z_renamed);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int x_renamed = (int) resultPoint.getX();
            for (int y_renamed = (int) resultPoint.getY(); y_renamed <= boundingBox.getMaxY() && y_renamed >= boundingBox.getMinY(); y_renamed += i4) {
                com.google.zxing.pdf417.decoder.Codeword codewordDetectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z_renamed, x_renamed, y_renamed, i_renamed, i2);
                if (codewordDetectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y_renamed, codewordDetectCodeword);
                    if (z_renamed) {
                        x_renamed = codewordDetectCodeword.getStartX();
                    } else {
                        x_renamed = codewordDetectCodeword.getEndX();
                    }
                }
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static void adjustCodewordCount(com.google.zxing.pdf417.decoder.DetectionResult detectionResult, com.google.zxing.pdf417.decoder.BarcodeValue[][] barcodeValueArr) throws com.google.zxing.NotFoundException {
        com.google.zxing.pdf417.decoder.BarcodeValue barcodeValue = barcodeValueArr[0][1];
        int[] value = barcodeValue.getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValue.setValue(barcodeColumnCount);
            }
        } else {
            if (barcodeColumnCount <= 0 || barcodeColumnCount > 928) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            barcodeValue.setValue(barcodeColumnCount);
        }
    }

    private static com.google.zxing.common.DecoderResult createDecoderResult(com.google.zxing.pdf417.decoder.DetectionResult detectionResult) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.pdf417.decoder.BarcodeValue[][] barcodeValueArrCreateBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, barcodeValueArrCreateBarcodeMatrix);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (int i_renamed = 0; i_renamed < detectionResult.getBarcodeRowCount(); i_renamed++) {
            int i2 = 0;
            while (i2 < detectionResult.getBarcodeColumnCount()) {
                int i3 = i2 + 1;
                int[] value = barcodeValueArrCreateBarcodeMatrix[i_renamed][i3].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i_renamed) + i2;
                if (value.length == 0) {
                    arrayList.add(java.lang.Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(java.lang.Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i2 = i3;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, com.google.zxing.pdf417.PDF417Common.toIntArray(arrayList), com.google.zxing.pdf417.PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static com.google.zxing.common.DecoderResult createDecoderResultFromAmbiguousValues(int i_renamed, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < iArr5.length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return decodeCodewords(iArr, i_renamed, iArr2);
                } catch (com.google.zxing.ChecksumException unused) {
                    if (iArr5.length == 0) {
                        throw com.google.zxing.ChecksumException.getChecksumInstance();
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= iArr5.length) {
                            break;
                        }
                        if (iArr5[i5] < iArr4[i5].length - 1) {
                            iArr5[i5] = iArr5[i5] + 1;
                            break;
                        }
                        iArr5[i5] = 0;
                        if (i5 == iArr5.length - 1) {
                            throw com.google.zxing.ChecksumException.getChecksumInstance();
                        }
                        i5++;
                    }
                    i2 = i3;
                }
            } else {
                throw com.google.zxing.ChecksumException.getChecksumInstance();
            }
        }
    }

    private static com.google.zxing.pdf417.decoder.BarcodeValue[][] createBarcodeMatrix(com.google.zxing.pdf417.decoder.DetectionResult detectionResult) {
        int rowNumber;
        com.google.zxing.pdf417.decoder.BarcodeValue[][] barcodeValueArr = (com.google.zxing.pdf417.decoder.BarcodeValue[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) com.google.zxing.pdf417.decoder.BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (int i_renamed = 0; i_renamed < barcodeValueArr.length; i_renamed++) {
            for (int i2 = 0; i2 < barcodeValueArr[i_renamed].length; i2++) {
                barcodeValueArr[i_renamed][i2] = new com.google.zxing.pdf417.decoder.BarcodeValue();
            }
        }
        int i3 = 0;
        for (com.google.zxing.pdf417.decoder.DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (com.google.zxing.pdf417.decoder.Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i3].setValue(codeword.getValue());
                    }
                }
            }
            i3++;
        }
        return barcodeValueArr;
    }

    private static boolean isValidBarcodeColumn(com.google.zxing.pdf417.decoder.DetectionResult detectionResult, int i_renamed) {
        return i_renamed >= 0 && i_renamed <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static int getStartColumn(com.google.zxing.pdf417.decoder.DetectionResult detectionResult, int i_renamed, int i2, boolean z_renamed) {
        int i3 = z_renamed ? 1 : -1;
        int i4 = i_renamed - i3;
        com.google.zxing.pdf417.decoder.Codeword codeword = isValidBarcodeColumn(detectionResult, i4) ? detectionResult.getDetectionResultColumn(i4).getCodeword(i2) : null;
        if (codeword != null) {
            return z_renamed ? codeword.getEndX() : codeword.getStartX();
        }
        com.google.zxing.pdf417.decoder.Codeword codewordNearby = detectionResult.getDetectionResultColumn(i_renamed).getCodewordNearby(i2);
        if (codewordNearby != null) {
            return z_renamed ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            return z_renamed ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i5 = 0;
        while (true) {
            i_renamed -= i3;
            if (!isValidBarcodeColumn(detectionResult, i_renamed)) {
                return z_renamed ? detectionResult.getBoundingBox().getMinX() : detectionResult.getBoundingBox().getMaxX();
            }
            for (com.google.zxing.pdf417.decoder.Codeword codeword2 : detectionResult.getDetectionResultColumn(i_renamed).getCodewords()) {
                if (codeword2 != null) {
                    return (z_renamed ? codeword2.getEndX() : codeword2.getStartX()) + (i3 * i5 * (codeword2.getEndX() - codeword2.getStartX()));
                }
            }
            i5++;
        }
    }

    private static com.google.zxing.pdf417.decoder.Codeword detectCodeword(com.google.zxing.common.BitMatrix bitMatrix, int i_renamed, int i2, boolean z_renamed, int i3, int i4, int i5, int i6) {
        int i7;
        int decodedValue;
        int codeword;
        int iAdjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i_renamed, i2, z_renamed, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i_renamed, i2, z_renamed, iAdjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int iSum = com.google.zxing.common.detector.MathUtils.sum(moduleBitCount);
        if (z_renamed) {
            iAdjustCodewordStartColumn += iSum;
            i7 = iAdjustCodewordStartColumn;
        } else {
            for (int i8 = 0; i8 < moduleBitCount.length / 2; i8++) {
                int i9 = moduleBitCount[i8];
                moduleBitCount[i8] = moduleBitCount[(moduleBitCount.length - 1) - i8];
                moduleBitCount[(moduleBitCount.length - 1) - i8] = i9;
            }
            i7 = iAdjustCodewordStartColumn - iSum;
        }
        if (checkCodewordSkew(iSum, i5, i6) && (codeword = com.google.zxing.pdf417.PDF417Common.getCodeword((decodedValue = com.google.zxing.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new com.google.zxing.pdf417.decoder.Codeword(i7, iAdjustCodewordStartColumn, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:11:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] getModuleBitCount(com.google.zxing.common.BitMatrix r8, int r9, int r10, boolean r11, int r12, int r13) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r11 == 0) goto L9
            r3 = r2
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r6 = r11
            r5 = r4
        Ld:
            if (r11 == 0) goto L12
            if (r12 >= r10) goto L2b
            goto L14
        L12:
            if (r12 < r9) goto L2b
        L14:
            if (r5 >= r0) goto L2b
            boolean r7 = r8.get(r12, r13)
            if (r7 != r6) goto L23
            r7 = r1[r5]
            int r7 = r7 + r2
            r1[r5] = r7
            int r12 = r12 + r3
            goto Ld
        L23:
            int r5 = r5 + 1
            if (r6 != 0) goto L29
            r6 = r2
            goto Ld
        L29:
            r6 = r4
            goto Ld
        L2b:
            if (r5 == r0) goto L38
            if (r11 == 0) goto L30
            r9 = r10
        L30:
            if (r12 != r9) goto L36
            r8 = 7
            if (r5 != r8) goto L36
            goto L38
        L36:
            r8 = 0
            return r8
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.getModuleBitCount(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int[]");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int adjustCodewordStartColumn(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 1
            if (r10 == 0) goto L5
            r1 = -1
            goto L6
        L5:
            r1 = r0
        L6:
            r2 = 0
            r4 = r10
            r3 = r1
            r10 = r2
            r1 = r11
        Lb:
            r5 = 2
            if (r10 >= r5) goto L2f
        Le:
            if (r4 == 0) goto L13
            if (r1 < r8) goto L26
            goto L15
        L13:
            if (r1 >= r9) goto L26
        L15:
            boolean r6 = r7.get(r1, r12)
            if (r4 != r6) goto L26
            int r6 = r11 - r1
            int r6 = java.lang.Math.abs(r6)
            if (r6 <= r5) goto L24
            return r11
        L24:
            int r1 = r1 + r3
            goto Le
        L26:
            int r3 = -r3
            if (r4 != 0) goto L2b
            r4 = r0
            goto L2c
        L2b:
            r4 = r2
        L2c:
            int r10 = r10 + 1
            goto Lb
        L2f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.adjustCodewordStartColumn(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int");
    }

    private static com.google.zxing.common.DecoderResult decodeCodewords(int[] iArr, int i_renamed, int[] iArr2) throws com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        if (iArr.length == 0) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        int i2 = 1 << (i_renamed + 1);
        int iCorrectErrors = correctErrors(iArr, iArr2, i2);
        verifyCodewordCount(iArr, i2);
        com.google.zxing.common.DecoderResult decoderResultDecode = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(iArr, java.lang.String.valueOf(i_renamed));
        decoderResultDecode.setErrorsCorrected(java.lang.Integer.valueOf(iCorrectErrors));
        decoderResultDecode.setErasures(java.lang.Integer.valueOf(iArr2.length));
        return decoderResultDecode;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i_renamed) throws com.google.zxing.ChecksumException {
        if ((iArr2 != null && iArr2.length > (i_renamed / 2) + 3) || i_renamed < 0 || i_renamed > 512) {
            throw com.google.zxing.ChecksumException.getChecksumInstance();
        }
        return errorCorrection.decode(iArr, i_renamed, iArr2);
    }

    private static void verifyCodewordCount(int[] iArr, int i_renamed) throws com.google.zxing.FormatException {
        if (iArr.length < 4) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw com.google.zxing.FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i_renamed < iArr.length) {
                iArr[0] = iArr.length - i_renamed;
                return;
            }
            throw com.google.zxing.FormatException.getFormatInstance();
        }
    }

    private static int[] getBitCountForCodeword(int i_renamed) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i_renamed & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i_renamed >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i_renamed) {
        return getCodewordBucketNumber(getBitCountForCodeword(i_renamed));
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static java.lang.String toString(com.google.zxing.pdf417.decoder.BarcodeValue[][] barcodeValueArr) {
        java.util.Formatter formatter = new java.util.Formatter();
        int i_renamed = 0;
        while (true) {
            java.lang.Throwable th = null;
            try {
                if (i_renamed < barcodeValueArr.length) {
                    formatter.format("Row %2d: ", java.lang.Integer.valueOf(i_renamed));
                    for (int i2 = 0; i2 < barcodeValueArr[i_renamed].length; i2++) {
                        com.google.zxing.pdf417.decoder.BarcodeValue barcodeValue = barcodeValueArr[i_renamed][i2];
                        if (barcodeValue.getValue().length == 0) {
                            formatter.format("        ", null);
                        } else {
                            formatter.format("%4d(%2d)", java.lang.Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                        }
                    }
                    formatter.format("%n_renamed", new java.lang.Object[0]);
                    i_renamed++;
                } else {
                    java.lang.String string = formatter.toString();
                    formatter.close();
                    return string;
                }
            } catch (java.lang.Throwable th2) {
                if (0 != 0) {
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
    }
}
