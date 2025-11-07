package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class UPCAWriter implements com.google.zxing.Writer {
    private final com.google.zxing.oned.EAN13Writer subWriter = new com.google.zxing.oned.EAN13Writer();

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2) throws com.google.zxing.WriterException {
        return encode(str, barcodeFormat, i_renamed, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        if (barcodeFormat != com.google.zxing.BarcodeFormat.UPC_A) {
            throw new java.lang.IllegalArgumentException("Can only encode UPC-A_renamed, but got ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return this.subWriter.encode("0".concat(java.lang.String.valueOf(str)), com.google.zxing.BarcodeFormat.EAN_13, i_renamed, i2, map);
    }
}
