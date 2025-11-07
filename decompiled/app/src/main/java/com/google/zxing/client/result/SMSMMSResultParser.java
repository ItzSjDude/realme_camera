package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class SMSMMSResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.SMSParsedResult parse(com.google.zxing.Result result) {
        java.lang.String str;
        java.lang.String strSubstring;
        java.lang.String massagedText = getMassagedText(result);
        java.lang.String str2 = null;
        if (!massagedText.startsWith("sms:") && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        java.util.Map<java.lang.String, java.lang.String> nameValuePairs = parseNameValuePairs(massagedText);
        boolean z_renamed = false;
        if (nameValuePairs == null || nameValuePairs.isEmpty()) {
            str = null;
        } else {
            str2 = nameValuePairs.get("subject");
            str = nameValuePairs.get(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_BODY);
            z_renamed = true;
        }
        int iIndexOf = massagedText.indexOf(63, 4);
        if (iIndexOf < 0 || !z_renamed) {
            strSubstring = massagedText.substring(4);
        } else {
            strSubstring = massagedText.substring(4, iIndexOf);
        }
        int i_renamed = -1;
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(1);
        while (true) {
            int i2 = i_renamed + 1;
            int iIndexOf2 = strSubstring.indexOf(44, i2);
            if (iIndexOf2 > i_renamed) {
                addNumberVia(arrayList, arrayList2, strSubstring.substring(i2, iIndexOf2));
                i_renamed = iIndexOf2;
            } else {
                addNumberVia(arrayList, arrayList2, strSubstring.substring(i2));
                return new com.google.zxing.client.result.SMSParsedResult((java.lang.String[]) arrayList.toArray(EMPTY_STR_ARRAY), (java.lang.String[]) arrayList2.toArray(EMPTY_STR_ARRAY), str2, str);
            }
        }
    }

    private static void addNumberVia(java.util.Collection<java.lang.String> collection, java.util.Collection<java.lang.String> collection2, java.lang.String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, iIndexOf));
            java.lang.String strSubstring = str.substring(iIndexOf + 1);
            collection2.add(strSubstring.startsWith("via=") ? strSubstring.substring(4) : null);
        }
    }
}
