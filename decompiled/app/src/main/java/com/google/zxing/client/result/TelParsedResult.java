package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class TelParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String number;
    private final java.lang.String telURI;
    private final java.lang.String title;

    public TelParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(com.google.zxing.client.result.ParsedResultType.TEL);
        this.number = str;
        this.telURI = str2;
        this.title = str3;
    }

    public java.lang.String getNumber() {
        return this.number;
    }

    public java.lang.String getTelURI() {
        return this.telURI;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        maybeAppend(this.number, sb);
        maybeAppend(this.title, sb);
        return sb.toString();
    }
}
