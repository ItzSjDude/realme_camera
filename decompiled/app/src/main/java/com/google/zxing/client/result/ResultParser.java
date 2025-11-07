package com.google.zxing.client.result;

/* loaded from: classes.dex */
public abstract class ResultParser {
    private static final java.lang.String BYTE_ORDER_MARK = "\ufeff";
    private static final com.google.zxing.client.result.ResultParser[] PARSERS = {new com.google.zxing.client.result.BookmarkDoCoMoResultParser(), new com.google.zxing.client.result.AddressBookDoCoMoResultParser(), new com.google.zxing.client.result.EmailDoCoMoResultParser(), new com.google.zxing.client.result.AddressBookAUResultParser(), new com.google.zxing.client.result.VCardResultParser(), new com.google.zxing.client.result.BizcardResultParser(), new com.google.zxing.client.result.VEventResultParser(), new com.google.zxing.client.result.EmailAddressResultParser(), new com.google.zxing.client.result.SMTPResultParser(), new com.google.zxing.client.result.TelResultParser(), new com.google.zxing.client.result.SMSMMSResultParser(), new com.google.zxing.client.result.SMSTOMMSTOResultParser(), new com.google.zxing.client.result.GeoResultParser(), new com.google.zxing.client.result.WifiResultParser(), new com.google.zxing.client.result.URLTOResultParser(), new com.google.zxing.client.result.URIResultParser(), new com.google.zxing.client.result.ISBNResultParser(), new com.google.zxing.client.result.ProductResultParser(), new com.google.zxing.client.result.ExpandedProductResultParser(), new com.google.zxing.client.result.VINResultParser()};
    private static final java.util.regex.Pattern DIGITS = java.util.regex.Pattern.compile("\\d_renamed+");
    private static final java.util.regex.Pattern AMPERSAND = java.util.regex.Pattern.compile("&");
    private static final java.util.regex.Pattern EQUALS = java.util.regex.Pattern.compile("=");
    static final java.lang.String[] EMPTY_STR_ARRAY = new java.lang.String[0];

    protected static int parseHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a_renamed';
        if (c2 < 'a_renamed' || c2 > 'f_renamed') {
            c3 = 'A_renamed';
            if (c2 < 'A_renamed' || c2 > 'F_renamed') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public abstract com.google.zxing.client.result.ParsedResult parse(com.google.zxing.Result result);

    protected static java.lang.String getMassagedText(com.google.zxing.Result result) {
        java.lang.String text = result.getText();
        return text.startsWith(BYTE_ORDER_MARK) ? text.substring(1) : text;
    }

    public static com.google.zxing.client.result.ParsedResult parseResult(com.google.zxing.Result result) {
        for (com.google.zxing.client.result.ResultParser resultParser : PARSERS) {
            com.google.zxing.client.result.ParsedResult parsedResult = resultParser.parse(result);
            if (parsedResult != null) {
                return parsedResult;
            }
        }
        return new com.google.zxing.client.result.TextParsedResult(result.getText(), null);
    }

    protected static void maybeAppend(java.lang.String str, java.lang.StringBuilder sb) {
        if (str != null) {
            sb.append('\n_renamed');
            sb.append(str);
        }
    }

    protected static void maybeAppend(java.lang.String[] strArr, java.lang.StringBuilder sb) {
        if (strArr != null) {
            for (java.lang.String str : strArr) {
                sb.append('\n_renamed');
                sb.append(str);
            }
        }
    }

    protected static java.lang.String[] maybeWrap(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return new java.lang.String[]{str};
    }

    protected static java.lang.String unescapeBackslash(java.lang.String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z_renamed = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z_renamed || cCharAt != '\\') {
                sb.append(cCharAt);
                z_renamed = false;
            } else {
                z_renamed = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    protected static boolean isStringOfDigits(java.lang.CharSequence charSequence, int i_renamed) {
        return charSequence != null && i_renamed > 0 && i_renamed == charSequence.length() && DIGITS.matcher(charSequence).matches();
    }

    protected static boolean isSubstringOfDigits(java.lang.CharSequence charSequence, int i_renamed, int i2) {
        int i3;
        return charSequence != null && i2 > 0 && charSequence.length() >= (i3 = i2 + i_renamed) && DIGITS.matcher(charSequence.subSequence(i_renamed, i3)).matches();
    }

    static java.util.Map<java.lang.String, java.lang.String> parseNameValuePairs(java.lang.String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            return null;
        }
        java.util.HashMap map = new java.util.HashMap(3);
        for (java.lang.String str2 : AMPERSAND.split(str.substring(iIndexOf + 1))) {
            appendKeyValue(str2, map);
        }
        return map;
    }

    private static void appendKeyValue(java.lang.CharSequence charSequence, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String[] strArrSplit = EQUALS.split(charSequence, 2);
        if (strArrSplit.length == 2) {
            try {
                map.put(strArrSplit[0], urlDecode(strArrSplit[1]));
            } catch (java.lang.IllegalArgumentException unused) {
            }
        }
    }

    static java.lang.String urlDecode(java.lang.String str) {
        try {
            return java.net.URLDecoder.decode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new java.lang.IllegalStateException(e_renamed);
        }
    }

    static java.lang.String[] matchPrefixedField(java.lang.String str, java.lang.String str2, char c2, boolean z_renamed) {
        int length;
        int length2 = str2.length();
        java.util.ArrayList arrayList = null;
        for (int i_renamed = 0; i_renamed < length2; i_renamed = length) {
            int iIndexOf = str2.indexOf(str, i_renamed);
            if (iIndexOf < 0) {
                break;
            }
            int length3 = iIndexOf + str.length();
            boolean z2 = true;
            length = length3;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c2, length);
                if (iIndexOf2 < 0) {
                    length = str2.length();
                } else if (countPrecedingBackslashes(str2, iIndexOf2) % 2 != 0) {
                    length = iIndexOf2 + 1;
                } else {
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList(3);
                    }
                    java.lang.String strUnescapeBackslash = unescapeBackslash(str2.substring(length3, iIndexOf2));
                    if (z_renamed) {
                        strUnescapeBackslash = strUnescapeBackslash.trim();
                    }
                    if (!strUnescapeBackslash.isEmpty()) {
                        arrayList.add(strUnescapeBackslash);
                    }
                    length = iIndexOf2 + 1;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(EMPTY_STR_ARRAY);
    }

    private static int countPrecedingBackslashes(java.lang.CharSequence charSequence, int i_renamed) {
        int i2 = 0;
        for (int i3 = i_renamed - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    static java.lang.String matchSinglePrefixedField(java.lang.String str, java.lang.String str2, char c2, boolean z_renamed) {
        java.lang.String[] strArrMatchPrefixedField = matchPrefixedField(str, str2, c2, z_renamed);
        if (strArrMatchPrefixedField == null) {
            return null;
        }
        return strArrMatchPrefixedField[0];
    }
}
