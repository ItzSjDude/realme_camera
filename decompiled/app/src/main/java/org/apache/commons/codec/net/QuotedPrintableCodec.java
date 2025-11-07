package org.apache.commons.codec.net;

/* loaded from: classes2.dex */
public class QuotedPrintableCodec implements org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.BinaryEncoder, org.apache.commons.codec.StringDecoder, org.apache.commons.codec.StringEncoder {
    private static final byte ESCAPE_CHAR = 61;
    private static final java.util.BitSet PRINTABLE_CHARS = new java.util.BitSet(256);
    private static final byte SPACE = 32;
    private static final byte TAB = 9;
    private final java.lang.String charset;

    static {
        for (int i_renamed = 33; i_renamed <= 60; i_renamed++) {
            PRINTABLE_CHARS.set(i_renamed);
        }
        for (int i2 = 62; i2 <= 126; i2++) {
            PRINTABLE_CHARS.set(i2);
        }
        PRINTABLE_CHARS.set(9);
        PRINTABLE_CHARS.set(32);
    }

    public QuotedPrintableCodec() {
        this("UTF-8");
    }

    public QuotedPrintableCodec(java.lang.String str) {
        this.charset = str;
    }

    private static final void encodeQuotedPrintable(int i_renamed, java.io.ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char upperCase = java.lang.Character.toUpperCase(java.lang.Character.forDigit((i_renamed >> 4) & 15, 16));
        char upperCase2 = java.lang.Character.toUpperCase(java.lang.Character.forDigit(i_renamed & 15, 16));
        byteArrayOutputStream.write(upperCase);
        byteArrayOutputStream.write(upperCase2);
    }

    public static final byte[] encodeQuotedPrintable(java.util.BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = PRINTABLE_CHARS;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        for (int i_renamed = 0; i_renamed < bArr.length; i_renamed++) {
            int i2 = bArr[i_renamed];
            if (i2 < 0) {
                i2 += 256;
            }
            if (bitSet.get(i2)) {
                byteArrayOutputStream.write(i2);
            } else {
                encodeQuotedPrintable(i2, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] decodeQuotedPrintable(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        if (bArr == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        int i_renamed = 0;
        while (i_renamed < bArr.length) {
            byte b2 = bArr[i_renamed];
            if (b2 == 61) {
                int i2 = i_renamed + 1;
                try {
                    int iDigit16 = org.apache.commons.codec.net.Utils.digit16(bArr[i2]);
                    i_renamed = i2 + 1;
                    byteArrayOutputStream.write((char) ((iDigit16 << 4) + org.apache.commons.codec.net.Utils.digit16(bArr[i_renamed])));
                } catch (java.lang.ArrayIndexOutOfBoundsException e_renamed) {
                    throw new org.apache.commons.codec.DecoderException("Invalid quoted-printable encoding", e_renamed);
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
        return encodeQuotedPrintable(PRINTABLE_CHARS, bArr);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        return decodeQuotedPrintable(bArr);
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
        stringBuffer.append(" cannot be_renamed quoted-printable encoded");
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
        stringBuffer.append(" cannot be_renamed quoted-printable decoded");
        throw new org.apache.commons.codec.DecoderException(stringBuffer.toString());
    }

    public java.lang.String getDefaultCharset() {
        return this.charset;
    }

    public java.lang.String encode(java.lang.String str, java.lang.String str2) throws java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return org.apache.commons.codec.binary.StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }
}
