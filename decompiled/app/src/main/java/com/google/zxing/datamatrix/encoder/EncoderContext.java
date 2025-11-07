package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class EncoderContext {
    private final java.lang.StringBuilder codewords;
    private com.google.zxing.Dimension maxSize;
    private com.google.zxing.Dimension minSize;
    private final java.lang.String msg;
    private int newEncoding;
    int pos;
    private com.google.zxing.datamatrix.encoder.SymbolShapeHint shape;
    private int skipAtEnd;
    private com.google.zxing.datamatrix.encoder.SymbolInfo symbolInfo;

    EncoderContext(java.lang.String str) {
        byte[] bytes = str.getBytes(java.nio.charset.StandardCharsets.ISO_8859_1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            char c2 = (char) (bytes[i_renamed] & 255);
            if (c2 == '?' && str.charAt(i_renamed) != '?') {
                throw new java.lang.IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.msg = sb.toString();
        this.shape = com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_NONE;
        this.codewords = new java.lang.StringBuilder(str.length());
        this.newEncoding = -1;
    }

    public void setSymbolShape(com.google.zxing.datamatrix.encoder.SymbolShapeHint symbolShapeHint) {
        this.shape = symbolShapeHint;
    }

    public void setSizeConstraints(com.google.zxing.Dimension dimension, com.google.zxing.Dimension dimension2) {
        this.minSize = dimension;
        this.maxSize = dimension2;
    }

    public java.lang.String getMessage() {
        return this.msg;
    }

    public void setSkipAtEnd(int i_renamed) {
        this.skipAtEnd = i_renamed;
    }

    public char getCurrentChar() {
        return this.msg.charAt(this.pos);
    }

    public char getCurrent() {
        return this.msg.charAt(this.pos);
    }

    public java.lang.StringBuilder getCodewords() {
        return this.codewords;
    }

    public void writeCodewords(java.lang.String str) {
        this.codewords.append(str);
    }

    public void writeCodeword(char c2) {
        this.codewords.append(c2);
    }

    public int getCodewordCount() {
        return this.codewords.length();
    }

    public int getNewEncoding() {
        return this.newEncoding;
    }

    public void signalEncoderChange(int i_renamed) {
        this.newEncoding = i_renamed;
    }

    public void resetEncoderSignal() {
        this.newEncoding = -1;
    }

    public boolean hasMoreCharacters() {
        return this.pos < getTotalMessageCharCount();
    }

    private int getTotalMessageCharCount() {
        return this.msg.length() - this.skipAtEnd;
    }

    public int getRemainingCharacters() {
        return getTotalMessageCharCount() - this.pos;
    }

    public com.google.zxing.datamatrix.encoder.SymbolInfo getSymbolInfo() {
        return this.symbolInfo;
    }

    public void updateSymbolInfo() {
        updateSymbolInfo(getCodewordCount());
    }

    public void updateSymbolInfo(int i_renamed) {
        com.google.zxing.datamatrix.encoder.SymbolInfo symbolInfo = this.symbolInfo;
        if (symbolInfo == null || i_renamed > symbolInfo.getDataCapacity()) {
            this.symbolInfo = com.google.zxing.datamatrix.encoder.SymbolInfo.lookup(i_renamed, this.shape, this.minSize, this.maxSize, true);
        }
    }

    public void resetSymbolInfo() {
        this.symbolInfo = null;
    }
}
