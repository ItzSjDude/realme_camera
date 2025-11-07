package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class SMSTOMMSTOResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.SMSParsedResult parse(com.google.zxing.Result result) {
        java.lang.String strSubstring;
        java.lang.String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("smsto:") && !massagedText.startsWith("SMSTO:") && !massagedText.startsWith("mmsto:") && !massagedText.startsWith("MMSTO:")) {
            return null;
        }
        java.lang.String strSubstring2 = massagedText.substring(6);
        int iIndexOf = strSubstring2.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = null;
        }
        return new com.google.zxing.client.result.SMSParsedResult(strSubstring2, (java.lang.String) null, (java.lang.String) null, strSubstring);
    }
}
