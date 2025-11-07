package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class AddressBookDoCoMoResultParser extends com.google.zxing.client.result.AbstractDoCoMoResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.AddressBookParsedResult parse(com.google.zxing.Result result) {
        java.lang.String[] strArrMatchDoCoMoPrefixedField;
        java.lang.String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("MECARD:") || (strArrMatchDoCoMoPrefixedField = matchDoCoMoPrefixedField("N_renamed:", massagedText, true)) == null) {
            return null;
        }
        java.lang.String name = parseName(strArrMatchDoCoMoPrefixedField[0]);
        java.lang.String strMatchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("SOUND:", massagedText, true);
        java.lang.String[] strArrMatchDoCoMoPrefixedField2 = matchDoCoMoPrefixedField("TEL:", massagedText, true);
        java.lang.String[] strArrMatchDoCoMoPrefixedField3 = matchDoCoMoPrefixedField("EMAIL:", massagedText, true);
        java.lang.String strMatchSingleDoCoMoPrefixedField2 = matchSingleDoCoMoPrefixedField("NOTE:", massagedText, false);
        java.lang.String[] strArrMatchDoCoMoPrefixedField4 = matchDoCoMoPrefixedField("ADR:", massagedText, true);
        java.lang.String strMatchSingleDoCoMoPrefixedField3 = matchSingleDoCoMoPrefixedField("BDAY:", massagedText, true);
        return new com.google.zxing.client.result.AddressBookParsedResult(maybeWrap(name), null, strMatchSingleDoCoMoPrefixedField, strArrMatchDoCoMoPrefixedField2, null, strArrMatchDoCoMoPrefixedField3, null, null, strMatchSingleDoCoMoPrefixedField2, strArrMatchDoCoMoPrefixedField4, null, matchSingleDoCoMoPrefixedField("ORG:", massagedText, true), !isStringOfDigits(strMatchSingleDoCoMoPrefixedField3, 8) ? null : strMatchSingleDoCoMoPrefixedField3, null, matchDoCoMoPrefixedField("URL:", massagedText, true), null);
    }

    private static java.lang.String parseName(java.lang.String str) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return str;
        }
        return str.substring(iIndexOf + 1) + ' ' + str.substring(0, iIndexOf);
    }
}
