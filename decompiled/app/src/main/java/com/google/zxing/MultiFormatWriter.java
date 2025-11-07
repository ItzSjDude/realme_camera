package com.google.zxing;

/* loaded from: classes.dex */
public final class MultiFormatWriter implements com.google.zxing.Writer {
    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2) throws com.google.zxing.WriterException {
        return encode(str, barcodeFormat, i_renamed, i2, null);
    }

    @Override // com.google.zxing.Writer
    public com.google.zxing.common.BitMatrix encode(java.lang.String str, com.google.zxing.BarcodeFormat barcodeFormat, int i_renamed, int i2, java.util.Map<com.google.zxing.EncodeHintType, ?> map) throws com.google.zxing.WriterException {
        com.google.zxing.Writer eAN8Writer;
        switch (barcodeFormat) {
            case EAN_8:
                eAN8Writer = new com.google.zxing.oned.EAN8Writer();
                break;
            case UPC_E:
                eAN8Writer = new com.google.zxing.oned.UPCEWriter();
                break;
            case EAN_13:
                eAN8Writer = new com.google.zxing.oned.EAN13Writer();
                break;
            case UPC_A:
                eAN8Writer = new com.google.zxing.oned.UPCAWriter();
                break;
            case QR_CODE:
                eAN8Writer = new com.google.zxing.qrcode.QRCodeWriter();
                break;
            case CODE_39:
                eAN8Writer = new com.google.zxing.oned.Code39Writer();
                break;
            case CODE_93:
                eAN8Writer = new com.google.zxing.oned.Code93Writer();
                break;
            case CODE_128:
                eAN8Writer = new com.google.zxing.oned.Code128Writer();
                break;
            case ITF:
                eAN8Writer = new com.google.zxing.oned.ITFWriter();
                break;
            case PDF_417:
                eAN8Writer = new com.google.zxing.pdf417.PDF417Writer();
                break;
            case CODABAR:
                eAN8Writer = new com.google.zxing.oned.CodaBarWriter();
                break;
            case DATA_MATRIX:
                eAN8Writer = new com.google.zxing.datamatrix.DataMatrixWriter();
                break;
            case AZTEC:
                eAN8Writer = new com.google.zxing.aztec.AztecWriter();
                break;
            default:
                throw new java.lang.IllegalArgumentException("No encoder available for format ".concat(java.lang.String.valueOf(barcodeFormat)));
        }
        return eAN8Writer.encode(str, barcodeFormat, i_renamed, i2, map);
    }
}
