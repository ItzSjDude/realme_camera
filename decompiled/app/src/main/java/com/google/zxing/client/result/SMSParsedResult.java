package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class SMSParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String body;
    private final java.lang.String[] numbers;
    private final java.lang.String subject;
    private final java.lang.String[] vias;

    public SMSParsedResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        super(com.google.zxing.client.result.ParsedResultType.SMS);
        this.numbers = new java.lang.String[]{str};
        this.vias = new java.lang.String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public SMSParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String str, java.lang.String str2) {
        super(com.google.zxing.client.result.ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }

    public java.lang.String getSMSURI() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("sms:");
        boolean z_renamed = true;
        for (int i_renamed = 0; i_renamed < this.numbers.length; i_renamed++) {
            if (z_renamed) {
                z_renamed = false;
            } else {
                sb.append(',');
            }
            sb.append(this.numbers[i_renamed]);
            java.lang.String[] strArr = this.vias;
            if (strArr != null && strArr[i_renamed] != null) {
                sb.append(";via=");
                sb.append(this.vias[i_renamed]);
            }
        }
        boolean z2 = this.body != null;
        boolean z3 = this.subject != null;
        if (z2 || z3) {
            sb.append('?');
            if (z2) {
                sb.append("body=");
                sb.append(this.body);
            }
            if (z3) {
                if (z2) {
                    sb.append('&');
                }
                sb.append("subject=");
                sb.append(this.subject);
            }
        }
        return sb.toString();
    }

    public java.lang.String[] getNumbers() {
        return this.numbers;
    }

    public java.lang.String[] getVias() {
        return this.vias;
    }

    public java.lang.String getSubject() {
        return this.subject;
    }

    public java.lang.String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        maybeAppend(this.numbers, sb);
        maybeAppend(this.subject, sb);
        maybeAppend(this.body, sb);
        return sb.toString();
    }
}
