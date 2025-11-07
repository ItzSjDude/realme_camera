package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class EmailAddressParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String[] bccs;
    private final java.lang.String body;
    private final java.lang.String[] ccs;
    private final java.lang.String subject;
    private final java.lang.String[] tos;

    @java.lang.Deprecated
    public java.lang.String getMailtoURI() {
        return "mailto:";
    }

    EmailAddressParsedResult(java.lang.String str) {
        this(new java.lang.String[]{str}, null, null, null, null);
    }

    EmailAddressParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3, java.lang.String str, java.lang.String str2) {
        super(com.google.zxing.client.result.ParsedResultType.EMAIL_ADDRESS);
        this.tos = strArr;
        this.ccs = strArr2;
        this.bccs = strArr3;
        this.subject = str;
        this.body = str2;
    }

    @java.lang.Deprecated
    public java.lang.String getEmailAddress() {
        java.lang.String[] strArr = this.tos;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    public java.lang.String[] getTos() {
        return this.tos;
    }

    public java.lang.String[] getCCs() {
        return this.ccs;
    }

    public java.lang.String[] getBCCs() {
        return this.bccs;
    }

    public java.lang.String getSubject() {
        return this.subject;
    }

    public java.lang.String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(30);
        maybeAppend(this.tos, sb);
        maybeAppend(this.ccs, sb);
        maybeAppend(this.bccs, sb);
        maybeAppend(this.subject, sb);
        maybeAppend(this.body, sb);
        return sb.toString();
    }
}
