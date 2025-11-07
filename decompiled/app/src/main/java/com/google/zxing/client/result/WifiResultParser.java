package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class WifiResultParser extends com.google.zxing.client.result.ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.WifiParsedResult parse(com.google.zxing.Result result) {
        java.lang.String strSubstring;
        java.lang.String strMatchSinglePrefixedField;
        java.lang.String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("WIFI:") || (strMatchSinglePrefixedField = matchSinglePrefixedField("S_renamed:", (strSubstring = massagedText.substring(5)), ';', false)) == null || strMatchSinglePrefixedField.isEmpty()) {
            return null;
        }
        java.lang.String strMatchSinglePrefixedField2 = matchSinglePrefixedField("P_renamed:", strSubstring, ';', false);
        java.lang.String strMatchSinglePrefixedField3 = matchSinglePrefixedField("T_renamed:", strSubstring, ';', false);
        if (strMatchSinglePrefixedField3 == null) {
            strMatchSinglePrefixedField3 = "nopass";
        }
        return new com.google.zxing.client.result.WifiParsedResult(strMatchSinglePrefixedField3, strMatchSinglePrefixedField, strMatchSinglePrefixedField2, java.lang.Boolean.parseBoolean(matchSinglePrefixedField("H_renamed:", strSubstring, ';', false)), matchSinglePrefixedField("I_renamed:", strSubstring, ';', false), matchSinglePrefixedField("A_renamed:", strSubstring, ';', false), matchSinglePrefixedField("E_renamed:", strSubstring, ';', false), matchSinglePrefixedField("H_renamed:", strSubstring, ';', false));
    }
}
