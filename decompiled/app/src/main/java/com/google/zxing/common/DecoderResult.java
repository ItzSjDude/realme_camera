package com.google.zxing.common;

/* loaded from: classes.dex */
public final class DecoderResult {
    private final java.util.List<byte[]> byteSegments;
    private final java.lang.String ecLevel;
    private java.lang.Integer erasures;
    private java.lang.Integer errorsCorrected;
    private int numBits;
    private java.lang.Object other;
    private final byte[] rawBytes;
    private final int structuredAppendParity;
    private final int structuredAppendSequenceNumber;
    private final java.lang.String text;

    public DecoderResult(byte[] bArr, java.lang.String str, java.util.List<byte[]> list, java.lang.String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public DecoderResult(byte[] bArr, java.lang.String str, java.util.List<byte[]> list, java.lang.String str2, int i_renamed, int i2) {
        this.rawBytes = bArr;
        this.numBits = bArr == null ? 0 : bArr.length * 8;
        this.text = str;
        this.byteSegments = list;
        this.ecLevel = str2;
        this.structuredAppendParity = i2;
        this.structuredAppendSequenceNumber = i_renamed;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public void setNumBits(int i_renamed) {
        this.numBits = i_renamed;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public java.util.List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    public java.lang.String getECLevel() {
        return this.ecLevel;
    }

    public java.lang.Integer getErrorsCorrected() {
        return this.errorsCorrected;
    }

    public void setErrorsCorrected(java.lang.Integer num) {
        this.errorsCorrected = num;
    }

    public java.lang.Integer getErasures() {
        return this.erasures;
    }

    public void setErasures(java.lang.Integer num) {
        this.erasures = num;
    }

    public java.lang.Object getOther() {
        return this.other;
    }

    public void setOther(java.lang.Object obj) {
        this.other = obj;
    }

    public boolean hasStructuredAppend() {
        return this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0;
    }

    public int getStructuredAppendParity() {
        return this.structuredAppendParity;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.structuredAppendSequenceNumber;
    }
}
