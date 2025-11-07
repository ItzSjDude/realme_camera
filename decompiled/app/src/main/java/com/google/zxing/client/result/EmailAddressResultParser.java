package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class EmailAddressResultParser extends com.google.zxing.client.result.ResultParser {
    private static final java.util.regex.Pattern COMMA = java.util.regex.Pattern.compile(",");

    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.EmailAddressParsedResult parse(com.google.zxing.Result result) {
        java.lang.String[] strArr;
        java.lang.String[] strArr2;
        java.lang.String[] strArr3;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String massagedText = getMassagedText(result);
        if (massagedText.startsWith("mailto:") || massagedText.startsWith("MAILTO:")) {
            java.lang.String strSubstring = massagedText.substring(7);
            int iIndexOf = strSubstring.indexOf(63);
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            try {
                java.lang.String strUrlDecode = urlDecode(strSubstring);
                java.lang.String[] strArrSplit = !strUrlDecode.isEmpty() ? COMMA.split(strUrlDecode) : null;
                java.util.Map<java.lang.String, java.lang.String> nameValuePairs = parseNameValuePairs(massagedText);
                if (nameValuePairs != null) {
                    if (strArrSplit == null && (str3 = nameValuePairs.get("to")) != null) {
                        strArrSplit = COMMA.split(str3);
                    }
                    java.lang.String str4 = nameValuePairs.get("cc_renamed");
                    java.lang.String[] strArrSplit2 = str4 != null ? COMMA.split(str4) : null;
                    java.lang.String str5 = nameValuePairs.get("bcc");
                    java.lang.String[] strArrSplit3 = str5 != null ? COMMA.split(str5) : null;
                    java.lang.String str6 = nameValuePairs.get("subject");
                    str2 = nameValuePairs.get(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_BODY);
                    strArr = strArrSplit;
                    strArr3 = strArrSplit3;
                    strArr2 = strArrSplit2;
                    str = str6;
                } else {
                    strArr = strArrSplit;
                    strArr2 = null;
                    strArr3 = null;
                    str = null;
                    str2 = null;
                }
                return new com.google.zxing.client.result.EmailAddressParsedResult(strArr, strArr2, strArr3, str, str2);
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }
        if (com.google.zxing.client.result.EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
            return new com.google.zxing.client.result.EmailAddressParsedResult(massagedText);
        }
        return null;
    }
}
