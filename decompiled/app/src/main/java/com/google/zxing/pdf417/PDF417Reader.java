package com.google.zxing.pdf417;

/* loaded from: classes.dex */
public final class PDF417Reader implements com.google.zxing.Reader, com.google.zxing.multi.MultipleBarcodeReader {
    private static final com.google.zxing.Result[] EMPTY_RESULT_ARRAY = new com.google.zxing.Result[0];

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        com.google.zxing.Result[] resultArrDecode = decode(binaryBitmap, map, false);
        if (resultArrDecode.length == 0 || resultArrDecode[0] == null) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
        return resultArrDecode[0];
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        try {
            return decode(binaryBitmap, map, true);
        } catch (com.google.zxing.ChecksumException | com.google.zxing.FormatException unused) {
            throw com.google.zxing.NotFoundException.getNotFoundInstance();
        }
    }

    private static com.google.zxing.Result[] decode(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map, boolean z_renamed) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.zxing.pdf417.detector.PDF417DetectorResult pDF417DetectorResultDetect = com.google.zxing.pdf417.detector.Detector.detect(binaryBitmap, map, z_renamed);
        for (com.google.zxing.ResultPoint[] resultPointArr : pDF417DetectorResultDetect.getPoints()) {
            com.google.zxing.common.DecoderResult decoderResultDecode = com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.decode(pDF417DetectorResultDetect.getBits(), resultPointArr[4], resultPointArr[5], resultPointArr[6], resultPointArr[7], getMinCodewordWidth(resultPointArr), getMaxCodewordWidth(resultPointArr));
            com.google.zxing.Result result = new com.google.zxing.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), resultPointArr, com.google.zxing.BarcodeFormat.PDF_417);
            result.putMetadata(com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL, decoderResultDecode.getECLevel());
            com.google.zxing.pdf417.PDF417ResultMetadata pDF417ResultMetadata = (com.google.zxing.pdf417.PDF417ResultMetadata) decoderResultDecode.getOther();
            if (pDF417ResultMetadata != null) {
                result.putMetadata(com.google.zxing.ResultMetadataType.PDF417_EXTRA_METADATA, pDF417ResultMetadata);
            }
            arrayList.add(result);
        }
        return (com.google.zxing.Result[]) arrayList.toArray(EMPTY_RESULT_ARRAY);
    }

    private static int getMaxWidth(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) java.lang.Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    private static int getMinWidth(com.google.zxing.ResultPoint resultPoint, com.google.zxing.ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) java.lang.Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    private static int getMaxCodewordWidth(com.google.zxing.ResultPoint[] resultPointArr) {
        return java.lang.Math.max(java.lang.Math.max(getMaxWidth(resultPointArr[0], resultPointArr[4]), (getMaxWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), java.lang.Math.max(getMaxWidth(resultPointArr[1], resultPointArr[5]), (getMaxWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }

    private static int getMinCodewordWidth(com.google.zxing.ResultPoint[] resultPointArr) {
        return java.lang.Math.min(java.lang.Math.min(getMinWidth(resultPointArr[0], resultPointArr[4]), (getMinWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), java.lang.Math.min(getMinWidth(resultPointArr[1], resultPointArr[5]), (getMinWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }
}
