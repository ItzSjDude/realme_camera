package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class URIParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String title;
    private final java.lang.String uri;

    public URIParsedResult(java.lang.String str, java.lang.String str2) {
        super(com.google.zxing.client.result.ParsedResultType.URI);
        this.uri = massageURI(str);
        this.title = str2;
    }

    public java.lang.String getURI() {
        return this.uri;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    @java.lang.Deprecated
    public boolean isPossiblyMaliciousURI() {
        return com.google.zxing.client.result.URIResultParser.isPossiblyMaliciousURI(this.uri);
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(30);
        maybeAppend(this.title, sb);
        maybeAppend(this.uri, sb);
        return sb.toString();
    }

    private static java.lang.String massageURI(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(58);
        return (iIndexOf < 0 || isColonFollowedByPortNumber(strTrim, iIndexOf)) ? "http://".concat(java.lang.String.valueOf(strTrim)) : strTrim;
    }

    private static boolean isColonFollowedByPortNumber(java.lang.String str, int i_renamed) {
        int i2 = i_renamed + 1;
        int iIndexOf = str.indexOf(47, i2);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return com.google.zxing.client.result.ResultParser.isSubstringOfDigits(str, i2, iIndexOf - i2);
    }
}
