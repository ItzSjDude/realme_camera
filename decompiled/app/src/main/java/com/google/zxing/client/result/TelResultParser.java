package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class TelResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.TelParsedResult parse(com.google.zxing.Result result) {
        java.lang.String str;
        java.lang.String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("tel:") && !massagedText.startsWith("TEL:")) {
            return null;
        }
        if (massagedText.startsWith("TEL:")) {
            str = "tel:" + massagedText.substring(4);
        } else {
            str = massagedText;
        }
        int iIndexOf = massagedText.indexOf(63, 4);
        return new com.google.zxing.client.result.TelParsedResult(iIndexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, iIndexOf), str, null);
    }
}
