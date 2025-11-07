package com.google.zxing.datamatrix;

/* loaded from: classes.dex */
public final class DataMatrixReader implements com.google.zxing.Reader {
    private static final com.google.zxing.ResultPoint[] NO_POINTS = new com.google.zxing.ResultPoint[0];
    private final com.google.zxing.datamatrix.decoder.Decoder decoder = new com.google.zxing.datamatrix.decoder.Decoder();

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.common.DecoderResult decoderResultDecode;
        com.google.zxing.ResultPoint[] points;
        if (map != null && map.containsKey(com.google.zxing.DecodeHintType.PURE_BARCODE)) {
            decoderResultDecode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()));
            points = NO_POINTS;
        } else {
            com.google.zxing.common.DetectorResult detectorResultDetect = new com.google.zxing.datamatrix.detector.Detector(binaryBitmap.getBlackMatrix()).detect();
            decoderResultDecode = this.decoder.decode(detectorResultDetect.getBits());
            points = detectorResultDetect.getPoints();
        }
        com.google.zxing.Result result = new com.google.zxing.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, com.google.zxing.BarcodeFormat.DATA_MATRIX);
        java.util.List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(com.google.zxing.ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        java.lang.String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }

    private static com.google.zxing.common.BitMatrix extractPureBits(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int iModuleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i_renamed = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = ((bottomRightOnBit[0] - i3) + 1) / iModuleSize;
        int i5 = ((i2 - i_renamed) + 1) / iModuleSize;
        if (i4 <= 0 || i5 <= 0) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i6 = iModuleSize / 2;
        int i7 = i_renamed + i6;
        int i8 = i3 + i6;
        com.google.zxing.common.BitMatrix bitMatrix2 = new com.google.zxing.common.BitMatrix(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * iModuleSize) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (bitMatrix.get((i11 * iModuleSize) + i8, i10)) {
                    bitMatrix2.set(i11, i9);
                }
            }
        }
        return bitMatrix2;
    }

    private static int moduleSize(int[] iArr, com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.NotFoundException {
        int width = bitMatrix.getWidth();
        int i_renamed = iArr[0];
        int i2 = iArr[1];
        while (i_renamed < width && bitMatrix.get(i_renamed, i2)) {
            i_renamed++;
        }
        if (i_renamed == width) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i3 = i_renamed - iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw com.google.zxing.NotFoundException.getNotFoundInstance();
    }
}
