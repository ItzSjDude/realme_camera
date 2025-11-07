package org.apache.commons.codec.net;

/* loaded from: classes2.dex */
public class BCodec extends org.apache.commons.codec.net.RFC1522Codec implements org.apache.commons.codec.StringDecoder, org.apache.commons.codec.StringEncoder {
    private final java.lang.String charset;

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected java.lang.String getEncoding() {
        return "B_renamed";
    }

    public BCodec() {
        this("UTF-8");
    }

    public BCodec(java.lang.String str) {
        this.charset = str;
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doEncoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return org.apache.commons.codec.binary.Base64.encodeBase64(bArr);
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doDecoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return org.apache.commons.codec.binary.Base64.decodeBase64(bArr);
    }

    public java.lang.String encode(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encodeText(str, str2);
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new org.apache.commons.codec.EncoderException(e_renamed.getMessage(), e_renamed);
        }
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) throws org.apache.commons.codec.EncoderException {
        if (str == null) {
            return null;
        }
        return encode(str, getDefaultCharset());
    }

    @Override // org.apache.commons.codec.StringDecoder
    public java.lang.String decode(java.lang.String str) throws org.apache.commons.codec.DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decodeText(str);
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new org.apache.commons.codec.DecoderException(e_renamed.getMessage(), e_renamed);
        }
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.String) {
            return encode((java.lang.String) obj);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Objects of_renamed type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be_renamed encoded using BCodec");
        throw new org.apache.commons.codec.EncoderException(stringBuffer.toString());
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.String) {
            return decode((java.lang.String) obj);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Objects of_renamed type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be_renamed decoded using BCodec");
        throw new org.apache.commons.codec.DecoderException(stringBuffer.toString());
    }

    public java.lang.String getDefaultCharset() {
        return this.charset;
    }
}
