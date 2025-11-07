package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class ProductResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.ProductParsedResult parse(com.google.zxing.Result result) {
        com.google.zxing.BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        if (barcodeFormat != com.google.zxing.BarcodeFormat.UPC_A && barcodeFormat != com.google.zxing.BarcodeFormat.UPC_E && barcodeFormat != com.google.zxing.BarcodeFormat.EAN_8 && barcodeFormat != com.google.zxing.BarcodeFormat.EAN_13) {
            return null;
        }
        java.lang.String massagedText = getMassagedText(result);
        if (isStringOfDigits(massagedText, massagedText.length())) {
            return new com.google.zxing.client.result.ProductParsedResult(massagedText, (barcodeFormat == com.google.zxing.BarcodeFormat.UPC_E && massagedText.length() == 8) ? com.google.zxing.oned.UPCEReader.convertUPCEtoUPCA(massagedText) : massagedText);
        }
        return null;
    }
}
