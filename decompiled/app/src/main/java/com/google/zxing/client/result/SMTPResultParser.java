package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class SMTPResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.EmailAddressParsedResult parse(com.google.zxing.Result result) {
        java.lang.String strSubstring;
        java.lang.String str;
        java.lang.String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("smtp:") && !massagedText.startsWith("SMTP:")) {
            return null;
        }
        java.lang.String strSubstring2 = massagedText.substring(5);
        int iIndexOf = strSubstring2.indexOf(58);
        if (iIndexOf >= 0) {
            java.lang.String strSubstring3 = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
            int iIndexOf2 = strSubstring3.indexOf(58);
            if (iIndexOf2 >= 0) {
                java.lang.String strSubstring4 = strSubstring3.substring(iIndexOf2 + 1);
                strSubstring = strSubstring3.substring(0, iIndexOf2);
                str = strSubstring4;
            } else {
                str = null;
                strSubstring = strSubstring3;
            }
        } else {
            strSubstring = null;
            str = null;
        }
        return new com.google.zxing.client.result.EmailAddressParsedResult(new java.lang.String[]{strSubstring2}, null, null, strSubstring, str);
    }
}
