package com.google.zxing.aztec;

/* loaded from: classes.dex */
public final class AztecWriter implements com.google.zxing.Writer {
    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2) {
        return encode(str, barcodeFormat, i_renamed, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws java.lang.NumberFormatException {
        java.nio.charset.Charset charsetForName = java.nio.charset.StandardCharsets.ISO_8859_1;
        int i3 = 0;
        if (map != null) {
            if (map.containsKey(com.google.zxing.EncodeHintType.CHARACTER_SET)) {
                charsetForName = java.nio.charset.Charset.forName(map.get(com.google.zxing.EncodeHintType.CHARACTER_SET).toString());
            }
            i_renamed = map.containsKey(com.google.zxing.EncodeHintType.ERROR_CORRECTION) ? java.lang.Integer.parseInt(map.get(com.google.zxing.EncodeHintType.ERROR_CORRECTION).toString()) : 33;
            if (map.containsKey(com.google.zxing.EncodeHintType.AZTEC_LAYERS)) {
                i3 = java.lang.Integer.parseInt(map.get(com.google.zxing.EncodeHintType.AZTEC_LAYERS).toString());
            }
        }
        return encode(str, barcodeFormat, i_renamed, i2, charsetForName, i_renamed, i3);
    }

    private static com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.nio.charset.Charset charset, int i3, int i4) {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.AZTEC) {
            throw new java.lang.IllegalArgumentException("Can only encode AZTEC, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return renderResult(com.google.zxing.aztec.encoder.Encoder.encode(str.getBytes(charset), i3, i4), i_renamed, i2);
    }

    private static com.google.zxing.common.BitMatrix renderResult(com.google.zxing.aztec.encoder.AztecCode aztecCode, int i_renamed, int i2) {
        com.google.zxing.common.BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new java.lang.IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int iMax = java.lang.Math.max(i_renamed, width);
        int iMax2 = java.lang.Math.max(i2, height);
        int iMin = java.lang.Math.min(iMax / width, iMax2 / height);
        int i3 = (iMax - (width * iMin)) / 2;
        int i4 = (iMax2 - (height * iMin)) / 2;
        com.google.zxing.common.BitMatrix bitMatrix = new com.google.zxing.common.BitMatrix(iMax, iMax2);
        int i5 = 0;
        while (i5 < height) {
            int i6 = 0;
            int i7 = i3;
            while (i6 < width) {
                if (matrix.get(i6, i5)) {
                    bitMatrix.setRegion(i7, i4, iMin, iMin);
                }
                i6++;
                i7 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return bitMatrix;
    }
}
