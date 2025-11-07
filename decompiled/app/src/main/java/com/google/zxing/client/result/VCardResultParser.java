package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class VCardResultParser extends com.google.zxing.client.result.ResultParser {
    private static final java.util.regex.Pattern BEGIN_VCARD = java.util.regex.Pattern.compile("BEGIN:VCARD", 2);
    private static final java.util.regex.Pattern VCARD_LIKE_DATE = java.util.regex.Pattern.compile("\\d_renamed{4}-?\\d_renamed{2}-?\\d_renamed{2}");
    private static final java.util.regex.Pattern CR_LF_SPACE_TAB = java.util.regex.Pattern.compile("\r_renamed\n_renamed[ \t_renamed]");
    private static final java.util.regex.Pattern NEWLINE_ESCAPE = java.util.regex.Pattern.compile("\\\\[nN]");
    private static final java.util.regex.Pattern VCARD_ESCAPES = java.util.regex.Pattern.compile("\\\\([,;\\\\])");
    private static final java.util.regex.Pattern EQUALS = java.util.regex.Pattern.compile("=");
    private static final java.util.regex.Pattern SEMICOLON = java.util.regex.Pattern.compile(";");
    private static final java.util.regex.Pattern UNESCAPED_SEMICOLONS = java.util.regex.Pattern.compile("(?<!\\\\);+");
    private static final java.util.regex.Pattern COMMA = java.util.regex.Pattern.compile(",");
    private static final java.util.regex.Pattern SEMICOLON_OR_COMMA = java.util.regex.Pattern.compile("[;,]");

    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.AddressBookParsedResult parse(com.google.zxing.Result result) {
        java.lang.String massagedText = getMassagedText(result);
        java.util.regex.Matcher matcher = BEGIN_VCARD.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField = matchVCardPrefixedField("FN", massagedText, true, false);
        if (listMatchVCardPrefixedField == null) {
            listMatchVCardPrefixedField = matchVCardPrefixedField("N_renamed", massagedText, true, false);
            formatNames(listMatchVCardPrefixedField);
        }
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
        java.lang.String[] strArrSplit = listMatchSingleVCardPrefixedField == null ? null : COMMA.split(listMatchSingleVCardPrefixedField.get(0));
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField2 = matchVCardPrefixedField("TEL", massagedText, true, false);
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField3 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("NOTE", massagedText, false, false);
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField4 = matchVCardPrefixedField("ADR", massagedText, true, true);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, true, false);
        java.util.List<java.lang.String> list = (listMatchSingleVCardPrefixedField4 == null || isLikeVCardDate(listMatchSingleVCardPrefixedField4.get(0))) ? listMatchSingleVCardPrefixedField4 : null;
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("TITLE", massagedText, true, false);
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField5 = matchVCardPrefixedField("URL", massagedText, true, false);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
        java.util.List<java.lang.String> listMatchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true, false);
        java.lang.String[] strArrSplit2 = listMatchSingleVCardPrefixedField7 == null ? null : SEMICOLON_OR_COMMA.split(listMatchSingleVCardPrefixedField7.get(0));
        return new com.google.zxing.client.result.AddressBookParsedResult(toPrimaryValues(listMatchVCardPrefixedField), strArrSplit, null, toPrimaryValues(listMatchVCardPrefixedField2), toTypes(listMatchVCardPrefixedField2), toPrimaryValues(listMatchVCardPrefixedField3), toTypes(listMatchVCardPrefixedField3), toPrimaryValue(listMatchSingleVCardPrefixedField6), toPrimaryValue(listMatchSingleVCardPrefixedField2), toPrimaryValues(listMatchVCardPrefixedField4), toTypes(listMatchVCardPrefixedField4), toPrimaryValue(listMatchSingleVCardPrefixedField3), toPrimaryValue(list), toPrimaryValue(listMatchSingleVCardPrefixedField5), toPrimaryValues(listMatchVCardPrefixedField5), (strArrSplit2 == null || strArrSplit2.length == 2) ? strArrSplit2 : null);
    }

    static java.util.List<java.util.List<java.lang.String>> matchVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z_renamed, boolean z2) {
        java.util.ArrayList arrayList;
        int i_renamed;
        java.lang.String str2;
        java.lang.String str3;
        int iIndexOf;
        int i2;
        java.lang.String strReplaceAll;
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        java.util.ArrayList arrayList2 = null;
        while (i4 < length) {
            int i5 = 2;
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("(?:^|\n_renamed)" + ((java.lang.Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i4 > 0) {
                i4--;
            }
            if (!matcher.find(i4)) {
                break;
            }
            int iEnd = matcher.end(i3);
            java.lang.String strGroup = matcher.group(1);
            if (strGroup != null) {
                java.lang.String[] strArrSplit = SEMICOLON.split(strGroup);
                int length2 = strArrSplit.length;
                int i6 = i3;
                i_renamed = i6;
                arrayList = null;
                str2 = null;
                str3 = null;
                while (i6 < length2) {
                    java.lang.String str4 = strArrSplit[i6];
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList(1);
                    }
                    arrayList.add(str4);
                    java.lang.String[] strArrSplit2 = EQUALS.split(str4, i5);
                    if (strArrSplit2.length > 1) {
                        java.lang.String str5 = strArrSplit2[0];
                        java.lang.String str6 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            i_renamed = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str2 = str6;
                        } else if ("VALUE".equalsIgnoreCase(str5)) {
                            str3 = str6;
                        }
                    }
                    i6++;
                    i5 = 2;
                }
            } else {
                arrayList = null;
                i_renamed = 0;
                str2 = null;
                str3 = null;
            }
            int i7 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i7);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i8 = iIndexOf + 1;
                    if (str.charAt(i8) == ' ' || str.charAt(i8) == '\t_renamed') {
                        i7 = iIndexOf + 2;
                    }
                }
                if (i_renamed == 0 || ((iIndexOf <= 0 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i7 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i4 = length;
                i3 = 0;
            } else if (iIndexOf <= iEnd) {
                i2 = 0;
                i3 = i2;
                i4 = iIndexOf + 1;
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList(1);
                }
                if (iIndexOf > 0 && str.charAt(iIndexOf - 1) == '\r_renamed') {
                    iIndexOf--;
                }
                java.lang.String strSubstring = str.substring(iEnd, iIndexOf);
                if (z_renamed) {
                    strSubstring = strSubstring.trim();
                }
                if (i_renamed != 0) {
                    strReplaceAll = decodeQuotedPrintable(strSubstring, str2);
                    if (z2) {
                        strReplaceAll = UNESCAPED_SEMICOLONS.matcher(strReplaceAll).replaceAll("\n_renamed").trim();
                    }
                } else {
                    if (z2) {
                        strSubstring = UNESCAPED_SEMICOLONS.matcher(strSubstring).replaceAll("\n_renamed").trim();
                    }
                    strReplaceAll = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(strSubstring).replaceAll("")).replaceAll("\n_renamed")).replaceAll("$1");
                }
                if (com.android.providers.downloads.Downloads.Impl.COLUMN_URI.equals(str3)) {
                    try {
                        strReplaceAll = java.net.URI.create(strReplaceAll).getSchemeSpecificPart();
                    } catch (java.lang.IllegalArgumentException unused) {
                    }
                }
                if (arrayList == null) {
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(1);
                    arrayList3.add(strReplaceAll);
                    arrayList2.add(arrayList3);
                    i2 = 0;
                    i3 = i2;
                    i4 = iIndexOf + 1;
                } else {
                    i2 = 0;
                    arrayList.add(0, strReplaceAll);
                    arrayList2.add(arrayList);
                    i3 = i2;
                    i4 = iIndexOf + 1;
                }
            }
        }
        return arrayList2;
    }

    private static java.lang.String decodeQuotedPrintable(java.lang.CharSequence charSequence, java.lang.String str) {
        char cCharAt;
        int length = charSequence.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int i_renamed = 0;
        while (i_renamed < length) {
            char cCharAt2 = charSequence.charAt(i_renamed);
            if (cCharAt2 != '\n_renamed' && cCharAt2 != '\r_renamed') {
                if (cCharAt2 != '=') {
                    maybeAppendFragment(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i_renamed < length - 2 && (cCharAt = charSequence.charAt(i_renamed + 1)) != '\r_renamed' && cCharAt != '\n_renamed') {
                    i_renamed += 2;
                    char cCharAt3 = charSequence.charAt(i_renamed);
                    int hexDigit = parseHexDigit(cCharAt);
                    int hexDigit2 = parseHexDigit(cCharAt3);
                    if (hexDigit >= 0 && hexDigit2 >= 0) {
                        byteArrayOutputStream.write((hexDigit << 4) + hexDigit2);
                    }
                }
            }
            i_renamed++;
        }
        maybeAppendFragment(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void maybeAppendFragment(java.io.ByteArrayOutputStream byteArrayOutputStream, java.lang.String str, java.lang.StringBuilder sb) {
        java.lang.String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new java.lang.String(byteArray, java.nio.charset.StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new java.lang.String(byteArray, str);
                } catch (java.io.UnsupportedEncodingException unused) {
                    str2 = new java.lang.String(byteArray, java.nio.charset.StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    static java.util.List<java.lang.String> matchSingleVCardPrefixedField(java.lang.CharSequence charSequence, java.lang.String str, boolean z_renamed, boolean z2) {
        java.util.List<java.util.List<java.lang.String>> listMatchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z_renamed, z2);
        if (listMatchVCardPrefixedField == null || listMatchVCardPrefixedField.isEmpty()) {
            return null;
        }
        return listMatchVCardPrefixedField.get(0);
    }

    private static java.lang.String toPrimaryValue(java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static java.lang.String[] toPrimaryValues(java.util.Collection<java.util.List<java.lang.String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<java.util.List<java.lang.String>> it = collection.iterator();
        while (it.hasNext()) {
            java.lang.String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (java.lang.String[]) arrayList.toArray(EMPTY_STR_ARRAY);
    }

    private static java.lang.String[] toTypes(java.util.Collection<java.util.List<java.lang.String>> collection) {
        java.lang.String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        for (java.util.List<java.lang.String> list : collection) {
            java.lang.String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                int i_renamed = 1;
                while (true) {
                    if (i_renamed >= list.size()) {
                        strSubstring = null;
                        break;
                    }
                    java.lang.String str2 = list.get(i_renamed);
                    int iIndexOf = str2.indexOf(61);
                    if (iIndexOf < 0) {
                        strSubstring = str2;
                        break;
                    }
                    if ("TYPE".equalsIgnoreCase(str2.substring(0, iIndexOf))) {
                        strSubstring = str2.substring(iIndexOf + 1);
                        break;
                    }
                    i_renamed++;
                }
                arrayList.add(strSubstring);
            }
        }
        return (java.lang.String[]) arrayList.toArray(EMPTY_STR_ARRAY);
    }

    private static boolean isLikeVCardDate(java.lang.CharSequence charSequence) {
        return charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches();
    }

    private static void formatNames(java.lang.Iterable<java.util.List<java.lang.String>> iterable) {
        int iIndexOf;
        if (iterable != null) {
            for (java.util.List<java.lang.String> list : iterable) {
                java.lang.String str = list.get(0);
                java.lang.String[] strArr = new java.lang.String[5];
                int i_renamed = 0;
                int i2 = 0;
                while (i_renamed < 4 && (iIndexOf = str.indexOf(59, i2)) >= 0) {
                    strArr[i_renamed] = str.substring(i2, iIndexOf);
                    i_renamed++;
                    i2 = iIndexOf + 1;
                }
                strArr[i_renamed] = str.substring(i2);
                java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
                maybeAppendComponent(strArr, 3, sb);
                maybeAppendComponent(strArr, 1, sb);
                maybeAppendComponent(strArr, 2, sb);
                maybeAppendComponent(strArr, 0, sb);
                maybeAppendComponent(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static void maybeAppendComponent(java.lang.String[] strArr, int i_renamed, java.lang.StringBuilder sb) {
        if (strArr[i_renamed] == null || strArr[i_renamed].isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i_renamed]);
    }
}
