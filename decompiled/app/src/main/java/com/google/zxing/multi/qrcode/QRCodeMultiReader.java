package com.google.zxing.multi.qrcode;

/* loaded from: classes.dex */
public final class QRCodeMultiReader extends com.google.zxing.qrcode.QRCodeReader implements com.google.zxing.multi.MultipleBarcodeReader {
    private static final com.google.zxing.Result[] EMPTY_RESULT_ARRAY = new com.google.zxing.Result[0];
    private static final com.google.zxing.ResultPoint[] NO_POINTS = new com.google.zxing.ResultPoint[0];

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap) throws com.google.zxing.NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public com.google.zxing.Result[] decodeMultiple(com.google.zxing.BinaryBitmap binaryBitmap, java.util.Map<com.google.zxing.DecodeHintType, ?> map) throws com.google.zxing.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.google.zxing.common.DetectorResult detectorResult : new com.google.zxing.multi.qrcode.detector.MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map)) {
            try {
                com.google.zxing.common.DecoderResult decoderResultDecode = getDecoder().decode(detectorResult.getBits(), map);
                com.google.zxing.ResultPoint[] points = detectorResult.getPoints();
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
                arrayList.add(result);
            } catch (com.google.zxing.ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        return (com.google.zxing.Result[]) processStructuredAppend(arrayList).toArray(EMPTY_RESULT_ARRAY);
    }

    static java.util.List<com.google.zxing.Result> processStructuredAppend(java.util.List<com.google.zxing.Result> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList<com.google.zxing.Result> arrayList2 = new java.util.ArrayList();
        for (com.google.zxing.Result result : list) {
            if (result.getResultMetadata().containsKey(com.google.zxing.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(result);
            } else {
                arrayList.add(result);
            }
        }
        if (arrayList2.isEmpty()) {
            return list;
        }
        java.util.Collections.sort(arrayList2, new com.google.zxing.multi.qrcode.QRCodeMultiReader.SAComparator());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
        for (com.google.zxing.Result result2 : arrayList2) {
            sb.append(result2.getText());
            byte[] rawBytes = result2.getRawBytes();
            byteArrayOutputStream.write(rawBytes, 0, rawBytes.length);
            java.lang.Iterable<byte[]> iterable = (java.lang.Iterable) result2.getResultMetadata().get(com.google.zxing.ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                for (byte[] bArr : iterable) {
                    byteArrayOutputStream2.write(bArr, 0, bArr.length);
                }
            }
        }
        com.google.zxing.Result result3 = new com.google.zxing.Result(sb.toString(), byteArrayOutputStream.toByteArray(), NO_POINTS, com.google.zxing.BarcodeFormat.QR_CODE);
        if (byteArrayOutputStream2.size() > 0) {
            result3.putMetadata(com.google.zxing.ResultMetadataType.BYTE_SEGMENTS, java.util.Collections.singletonList(byteArrayOutputStream2.toByteArray()));
        }
        arrayList.add(result3);
        return arrayList;
    }

    private static final class SAComparator implements java.io.Serializable, java.util.Comparator<com.google.zxing.Result> {
        private SAComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.google.zxing.Result result, com.google.zxing.Result result2) {
            return java.lang.Integer.compare(((java.lang.Integer) result.getResultMetadata().get(com.google.zxing.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue(), ((java.lang.Integer) result2.getResultMetadata().get(com.google.zxing.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue());
        }
    }
}
