package com.google.zxing.qrcode;

/* loaded from: classes.dex */
public final class QRCodeWriter implements com.google.zxing.Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2) throws com.google.zxing.WriterException {
        return encode(str, barcodeFormat, i_renamed, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws java.lang.NumberFormatException, com.google.zxing.WriterException {
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != com.google.zxing.BarcodeFormat.QR_CODE) {
            throw new java.lang.IllegalArgumentException("Can only encode QR_CODE, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        if (i_renamed < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Requested dimensions are too small: " + i_renamed + 'x_renamed' + i2);
        }
        com.google.zxing.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevelValueOf = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.L_renamed;
        int i3 = 4;
        if (map != null) {
            if (map.containsKey(com.google.zxing.EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevelValueOf = com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.valueOf(map.get(com.google.zxing.EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(com.google.zxing.EncodeHintType.MARGIN)) {
                i3 = java.lang.Integer.parseInt(map.get(com.google.zxing.EncodeHintType.MARGIN).toString());
            }
        }
        return renderResult(com.google.zxing.qrcode.encoder.Encoder.encode(str, errorCorrectionLevelValueOf, map), i_renamed, i2, i3);
    }

    private static com.google.zxing.common.BitMatrix renderResult(com.google.zxing.qrcode.encoder.QRCode qRCode, int i_renamed, int i2, int i3) {
        com.google.zxing.qrcode.encoder.ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new java.lang.IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i4 = i3 << 1;
        int i5 = width + i4;
        int i6 = i4 + height;
        int iMax = java.lang.Math.max(i_renamed, i5);
        int iMax2 = java.lang.Math.max(i2, i6);
        int iMin = java.lang.Math.min(iMax / i5, iMax2 / i6);
        int i7 = (iMax - (width * iMin)) / 2;
        int i8 = (iMax2 - (height * iMin)) / 2;
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(iMax, iMax2);
        int i9 = 0;
        while (i9 < height) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < width) {
                if (matrix.get(i10, i9) == 1) {
                    bitMatrix.setRegion(i11, i8, iMin, iMin);
                }
                i10++;
                i11 += iMin;
            }
            i9++;
            i8 += iMin;
        }
        return bitMatrix;
    }
}
