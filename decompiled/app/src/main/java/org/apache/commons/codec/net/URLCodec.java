package org.apache.commons.codec.net;

/* loaded from: classes2.dex */
public class URLCodec implements org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.BinaryEncoder, org.apache.commons.codec.StringDecoder, org.apache.commons.codec.StringEncoder {
    protected static final byte ESCAPE_CHAR = 37;
    static final int RADIX = 16;
    protected static final java.util.BitSet WWW_FORM_URL = new java.util.BitSet(256);
    protected java.lang.String charset;

    static {
        for (int i_renamed = 97; i_renamed <= 122; i_renamed++) {
            WWW_FORM_URL.set(i_renamed);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            WWW_FORM_URL.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            WWW_FORM_URL.set(i3);
        }
        WWW_FORM_URL.set(45);
        WWW_FORM_URL.set(95);
        WWW_FORM_URL.set(46);
        WWW_FORM_URL.set(42);
        WWW_FORM_URL.set(32);
    }

    public URLCodec() {
        this("UTF-8");
    }

    public URLCodec(java.lang.String str) {
        this.charset = str;
    }

    public static final byte[] encodeUrl(java.util.BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = WWW_FORM_URL;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            int i2 = bArr[i_renamed];
            if (i2 < 0) {
                i2 += 256;
            }
            if (bitSet.get(i2)) {
                if (i2 == 32) {
                    i2 = 43;
                }
                byteArrayOutputStream.write(i2);
            } else {
                byteArrayOutputStream.write(37);
                char upperCase = java.lang.Character.toUpperCase(java.lang.Character.forDigit((i2 >> 4) & 15, 16));
                char upperCase2 = java.lang.Character.toUpperCase(java.lang.Character.forDigit(i2 & 15, 16));
                byteArrayOutputStream.write(upperCase);
                byteArrayOutputStream.write(upperCase2);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] decodeUrl(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        if (bArr == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int i_renamed = 0;
        while (i_renamed < bArr.length) {
            byte b2 = bArr[i_renamed];
            if (b2 == 43) {
                byteArrayOutputStream.write(32);
            } else if (b2 == 37) {
                int i2 = i_renamed + 1;
                try {
                    int iDigit16 = org.apache.commons.codec.net.Utils.digit16(bArr[i2]);
                    i_renamed = i2 + 1;
                    byteArrayOutputStream.write((char) ((iDigit16 << 4) + org.apache.commons.codec.net.Utils.digit16(bArr[i_renamed])));
                } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
                    throw new org.apache.commons.codec.DecoderException("Invalid URL encoding: ", e_renamed);
                }
            } else {
                byteArrayOutputStream.write(b2);
            }
            i_renamed++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeUrl(WWW_FORM_URL, bArr);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        return decodeUrl(bArr);
    }

    public java.lang.String encode(java.lang.String str, java.lang.String str2) throws java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return org.apache.commons.codec.binary.StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) throws org.apache.commons.codec.EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encode(str, getDefaultCharset());
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new org.apache.commons.codec.EncoderException(e_renamed.getMessage(), e_renamed);
        }
    }

    public java.lang.String decode(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.DecoderException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new java.lang.String(decode(org.apache.commons.codec.binary.StringUtils.getBytesUsAscii(str)), str2);
    }

    @Override // org.apache.commons.codec.StringDecoder
    public java.lang.String decode(java.lang.String str) throws org.apache.commons.codec.DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decode(str, getDefaultCharset());
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new org.apache.commons.codec.DecoderException(e_renamed.getMessage(), e_renamed);
        }
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return encode((java.lang.String) obj);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Objects of_renamed type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be_renamed URL encoded");
        throw new org.apache.commons.codec.EncoderException(stringBuffer.toString());
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return decode((java.lang.String) obj);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Objects of_renamed type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(" cannot be_renamed URL decoded");
        throw new org.apache.commons.codec.DecoderException(stringBuffer.toString());
    }

    public java.lang.String getEncoding() {
        return this.charset;
    }

    public java.lang.String getDefaultCharset() {
        return this.charset;
    }
}
