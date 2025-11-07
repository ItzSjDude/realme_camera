package com.google.zxing.qrcode;

/* loaded from: classes.dex */
public class QRCodeReader implements com.google.zxing.Reader {
    private static final com.google.zxing.ResultPoint[] NO_POINTS = new com.google.zxing.ResultPoint[0];
    private final com.google.zxing.qrcode.decoder.Decoder decoder = new com.google.zxing.qrcode.decoder.Decoder();

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    protected final com.google.zxing.qrcode.decoder.Decoder getDecoder() {
        return this.decoder;
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public final com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.common.DecoderResult decoderResultDecode;
        com.google.zxing.ResultPoint[] points;
        if (map != null && map.containsKey(com.google.zxing.DecodeHintType.PURE_BARCODE)) {
            decoderResultDecode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            points = NO_POINTS;
        } else {
            com.google.zxing.common.DetectorResult detectorResultDetect = new com.google.zxing.qrcode.detector.Detector(binaryBitmap.getBlackMatrix()).detect(map);
            decoderResultDecode = this.decoder.decode(detectorResultDetect.getBits(), map);
            points = detectorResultDetect.getPoints();
        }
        if (decoderResultDecode.getOther() instanceof com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData) {
            ((com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData) decoderResultDecode.getOther()).applyMirroredCorrection(points);
        }
        com.google.zxing.Result result = new com.google.zxing.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, com.google.zxing.BarcodeFormat.QR_CODE);
        java.util.List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(com.google.zxing.ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        java.lang.String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decoderResultDecode.hasStructuredAppend()) {
            result.putMetadata(com.google.zxing.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, java.lang.Integer.valueOf(decoderResultDecode.getStructuredAppendSequenceNumber()));
            result.putMetadata(com.google.zxing.ResultMetadataType.STRUCTURED_APPEND_PARITY, java.lang.Integer.valueOf(decoderResultDecode.getStructuredAppendParity()));
        }
        return result;
    }

    private static com.google.zxing.common.BitMatrix extractPureBits(com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        float fModuleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i_renamed = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i_renamed >= i2) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i_renamed;
        if (i5 != i4 - i3 && (i4 = i3 + i5) >= bitMatrix.getWidth()) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int iRound = java.lang.Math.round(((i4 - i3) + 1) / fModuleSize);
        int iRound2 = java.lang.Math.round((i5 + 1) / fModuleSize);
        if (iRound <= 0 || iRound2 <= 0) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        int i6 = (int) (fModuleSize / 2.0f);
        int i7 = i_renamed + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * fModuleSize)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * fModuleSize)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw com.google.zxing.NotFoundException.getNotFoundInstance();
            }
            i7 -= i10;
        }
        com.google.zxing.common.BitMatrix bitMatrix2 = new com.google.zxing.common.BitMatrix(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * fModuleSize)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (bitMatrix.get(((int) (i13 * fModuleSize)) + i8, i12)) {
                    bitMatrix2.set(i13, i11);
                }
            }
        }
        return bitMatrix2;
    }

    private static float moduleSize(int[] iArr, com.google.zxing.common.BitMatrix bitMatrix) throws com.google.zxing.NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i_renamed = iArr[0];
        boolean z_renamed = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i_renamed < width && i2 < height) {
            if (z_renamed != bitMatrix.get(i_renamed, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z_renamed = !z_renamed;
            }
            i_renamed++;
            i2++;
        }
        if (i_renamed == width || i2 == height) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        return (i_renamed - iArr[0]) / 7.0f;
    }
}
