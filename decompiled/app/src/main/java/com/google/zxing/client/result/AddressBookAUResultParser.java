package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class AddressBookAUResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.AddressBookParsedResult parse(com.google.zxing.Result result) {
        java.lang.String massagedText = getMassagedText(result);
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r_renamed\n_renamed")) {
            return null;
        }
        java.lang.String strMatchSinglePrefixedField = matchSinglePrefixedField("NAME1:", massagedText, '\r_renamed', true);
        java.lang.String strMatchSinglePrefixedField2 = matchSinglePrefixedField("NAME2:", massagedText, '\r_renamed', true);
        java.lang.String[] strArrMatchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
        java.lang.String[] strArrMatchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, massagedText, true);
        java.lang.String strMatchSinglePrefixedField3 = matchSinglePrefixedField("MEMORY:", massagedText, '\r_renamed', false);
        java.lang.String strMatchSinglePrefixedField4 = matchSinglePrefixedField("ADD:", massagedText, '\r_renamed', true);
        return new com.google.zxing.client.result.AddressBookParsedResult(maybeWrap(strMatchSinglePrefixedField), null, strMatchSinglePrefixedField2, strArrMatchMultipleValuePrefix, null, strArrMatchMultipleValuePrefix2, null, null, strMatchSinglePrefixedField3, strMatchSinglePrefixedField4 != null ? new java.lang.String[]{strMatchSinglePrefixedField4} : null, null, null, null, null, null, null);
    }

    private static java.lang.String[] matchMultipleValuePrefix(java.lang.String str, int i_renamed, java.lang.String str2, boolean z_renamed) {
        java.util.ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i_renamed; i2++) {
            java.lang.String strMatchSinglePrefixedField = matchSinglePrefixedField(str + i2 + ':', str2, '\r_renamed', z_renamed);
            if (strMatchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new java.util.ArrayList(i_renamed);
            }
            arrayList.add(strMatchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(EMPTY_STR_ARRAY);
    }
}
