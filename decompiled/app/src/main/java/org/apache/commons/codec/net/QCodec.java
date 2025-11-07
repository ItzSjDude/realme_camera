package org.apache.commons.codec.net;

/* loaded from: classes2.dex */
public class QCodec extends org.apache.commons.codec.net.RFC1522Codec implements org.apache.commons.codec.StringDecoder, org.apache.commons.codec.StringEncoder {
    private static final byte BLANK = 32;
    private static final java.util.BitSet PRINTABLE_CHARS = new java.util.BitSet(256);
    private static final byte UNDERSCORE = 95;
    private final java.lang.String charset;
    private boolean encodeBlanks;

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected java.lang.String getEncoding() {
        return "Q_renamed";
    }

    static {
        PRINTABLE_CHARS.set(32);
        PRINTABLE_CHARS.set(33);
        PRINTABLE_CHARS.set(34);
        PRINTABLE_CHARS.set(35);
        PRINTABLE_CHARS.set(36);
        PRINTABLE_CHARS.set(37);
        PRINTABLE_CHARS.set(38);
        PRINTABLE_CHARS.set(39);
        PRINTABLE_CHARS.set(40);
        PRINTABLE_CHARS.set(41);
        PRINTABLE_CHARS.set(42);
        PRINTABLE_CHARS.set(43);
        PRINTABLE_CHARS.set(44);
        PRINTABLE_CHARS.set(45);
        PRINTABLE_CHARS.set(46);
        PRINTABLE_CHARS.set(47);
        for (int i_renamed = 48; i_renamed <= 57; i_renamed++) {
            PRINTABLE_CHARS.set(i_renamed);
        }
        PRINTABLE_CHARS.set(58);
        PRINTABLE_CHARS.set(59);
        PRINTABLE_CHARS.set(60);
        PRINTABLE_CHARS.set(62);
        PRINTABLE_CHARS.set(64);
        for (int i2 = 65; i2 <= 90; i2++) {
            PRINTABLE_CHARS.set(i2);
        }
        PRINTABLE_CHARS.set(91);
        PRINTABLE_CHARS.set(92);
        PRINTABLE_CHARS.set(93);
        PRINTABLE_CHARS.set(94);
        PRINTABLE_CHARS.set(96);
        for (int i3 = 97; i3 <= 122; i3++) {
            PRINTABLE_CHARS.set(i3);
        }
        PRINTABLE_CHARS.set(123);
        PRINTABLE_CHARS.set(124);
        PRINTABLE_CHARS.set(125);
        PRINTABLE_CHARS.set(126);
    }

    public QCodec() {
        this("UTF-8");
    }

    public QCodec(java.lang.String str) {
        this.encodeBlanks = false;
        this.charset = str;
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doEncoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArrEncodeQuotedPrintable = org.apache.commons.codec.net.QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, bArr);
        if (this.encodeBlanks) {
            for (int i_renamed = 0; i_renamed < bArrEncodeQuotedPrintable.length; i_renamed++) {
                if (bArrEncodeQuotedPrintable[i_renamed] == 32) {
                    bArrEncodeQuotedPrintable[i_renamed] = UNDERSCORE;
                }
            }
        }
        return bArrEncodeQuotedPrintable;
    }

    @Override // org.apache.commons.codec.net.RFC1522Codec
    protected byte[] doDecoding(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        boolean z_renamed;
        if (bArr == null) {
            return null;
        }
        int i_renamed = 0;
        while (true) {
            if (i_renamed >= bArr.length) {
                z_renamed = false;
                break;
            }
            if (bArr[i_renamed] == 95) {
                z_renamed = true;
                break;
            }
            i_renamed++;
        }
        if (z_renamed) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b2 = bArr[i2];
                if (b2 != 95) {
                    bArr2[i2] = b2;
                } else {
                    bArr2[i2] = BLANK;
                }
            }
            return org.apache.commons.codec.net.QuotedPrintableCodec.decodeQuotedPrintable(bArr2);
        }
        return org.apache.commons.codec.net.QuotedPrintableCodec.decodeQuotedPrintable(bArr);
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
        stringBuffer.append(" cannot be_renamed encoded using Q_renamed codec");
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
        stringBuffer.append(" cannot be_renamed decoded using Q_renamed codec");
        throw new org.apache.commons.codec.DecoderException(stringBuffer.toString());
    }

    public java.lang.String getDefaultCharset() {
        return this.charset;
    }

    public boolean isEncodeBlanks() {
        return this.encodeBlanks;
    }

    public void setEncodeBlanks(boolean z_renamed) {
        this.encodeBlanks = z_renamed;
    }
}
