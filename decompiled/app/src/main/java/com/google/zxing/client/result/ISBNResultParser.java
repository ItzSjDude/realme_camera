package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class ISBNResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.ISBNParsedResult parse(com.google.zxing.Result result) {
        if (result.getBarcodeFormat() != com.google.zxing.BarcodeFormat.EAN_13) {
            return null;
        }
        java.lang.String massagedText = getMassagedText(result);
        if (massagedText.length() != 13) {
            return null;
        }
        if (massagedText.startsWith("978") || massagedText.startsWith("979")) {
            return new com.google.zxing.client.result.ISBNParsedResult(massagedText);
        }
        return null;
    }
}
