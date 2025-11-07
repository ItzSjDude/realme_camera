package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class BookmarkDoCoMoResultParser extends com.google.zxing.client.result.AbstractDoCoMoResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public com.google.zxing.client.result.URIParsedResult parse(com.google.zxing.Result result) {
        java.lang.String text = result.getText();
        if (!text.startsWith("MEBKM:")) {
            return null;
        }
        java.lang.String strMatchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("TITLE:", text, true);
        java.lang.String[] strArrMatchDoCoMoPrefixedField = matchDoCoMoPrefixedField("URL:", text, true);
        if (strArrMatchDoCoMoPrefixedField == null) {
            return null;
        }
        java.lang.String str = strArrMatchDoCoMoPrefixedField[0];
        if (com.google.zxing.client.result.URIResultParser.isBasicallyValidURI(str)) {
            return new com.google.zxing.client.result.URIParsedResult(str, strMatchSingleDoCoMoPrefixedField);
        }
        return null;
    }
}
