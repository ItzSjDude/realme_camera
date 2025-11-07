package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class BizcardResultParser extends com.google.zxing.client.result.AbstractDoCoMoResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.AddressBookParsedResult parse(com.google.zxing.Result result) {
        java.lang.String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        java.lang.String strBuildName = buildName(matchSingleDoCoMoPrefixedField("N_renamed:", massagedText, true), matchSingleDoCoMoPrefixedField("X_renamed:", massagedText, true));
        java.lang.String strMatchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("T_renamed:", massagedText, true);
        java.lang.String strMatchSingleDoCoMoPrefixedField2 = matchSingleDoCoMoPrefixedField("C_renamed:", massagedText, true);
        return new com.google.zxing.client.result.AddressBookParsedResult(maybeWrap(strBuildName), null, null, buildPhoneNumbers(matchSingleDoCoMoPrefixedField("B_renamed:", massagedText, true), matchSingleDoCoMoPrefixedField("M_renamed:", massagedText, true), matchSingleDoCoMoPrefixedField("F_renamed:", massagedText, true)), null, maybeWrap(matchSingleDoCoMoPrefixedField("E_renamed:", massagedText, true)), null, null, null, matchDoCoMoPrefixedField("A_renamed:", massagedText, true), null, strMatchSingleDoCoMoPrefixedField2, null, strMatchSingleDoCoMoPrefixedField, null, null);
    }

    private static java.lang.String[] buildPhoneNumbers(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[size]);
    }

    private static java.lang.String buildName(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }
}
