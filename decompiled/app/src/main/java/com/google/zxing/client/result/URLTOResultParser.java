package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class URLTOResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.URIParsedResult parse(com.google.zxing.Result result) {
        int iIndexOf;
        java.lang.String massagedText = getMassagedText(result);
        if ((massagedText.startsWith("urlto:") || massagedText.startsWith("URLTO:")) && (iIndexOf = massagedText.indexOf(58, 6)) >= 0) {
            return new com.google.zxing.client.result.URIParsedResult(massagedText.substring(iIndexOf + 1), iIndexOf > 6 ? massagedText.substring(6, iIndexOf) : null);
        }
        return null;
    }
}
