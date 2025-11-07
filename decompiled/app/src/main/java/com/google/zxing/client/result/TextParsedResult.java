package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class TextParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String language;
    private final java.lang.String text;

    public TextParsedResult(java.lang.String str, java.lang.String str2) {
        super(com.google.zxing.client.result.ParsedResultType.TEXT);
        this.text = str;
        this.language = str2;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public java.lang.String getLanguage() {
        return this.language;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        return this.text;
    }
}
