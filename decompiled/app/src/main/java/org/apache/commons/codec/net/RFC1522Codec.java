package org.apache.commons.codec.net;

/* loaded from: classes2.dex */
abstract class RFC1522Codec {
    protected static final java.lang.String POSTFIX = "?=";
    protected static final java.lang.String PREFIX = "=?";
    protected static final char SEP = '?';

    protected abstract byte[] doDecoding(byte[] bArr) throws org.apache.commons.codec.DecoderException;

    protected abstract byte[] doEncoding(byte[] bArr) throws org.apache.commons.codec.EncoderException;

    protected abstract java.lang.String getEncoding();

    RFC1522Codec() {
    }

    protected java.lang.String encodeText(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(PREFIX);
        stringBuffer.append(str2);
        stringBuffer.append(SEP);
        stringBuffer.append(getEncoding());
        stringBuffer.append(SEP);
        stringBuffer.append(org.apache.commons.codec.binary.StringUtils.newStringUsAscii(doEncoding(str.getBytes(str2))));
        stringBuffer.append(POSTFIX);
        return stringBuffer.toString();
    }

    protected java.lang.String decodeText(java.lang.String str) throws org.apache.commons.codec.DecoderException, java.io.UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(PREFIX) || !str.endsWith(POSTFIX)) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int iIndexOf = str.indexOf(63, 2);
        if (iIndexOf == length) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: charset token not found");
        }
        java.lang.String strSubstring = str.substring(2, iIndexOf);
        if (strSubstring.equals("")) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: charset not specified");
        }
        int i_renamed = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(63, i_renamed);
        if (iIndexOf2 == length) {
            throw new org.apache.commons.codec.DecoderException("RFC 1522 violation: encoding token not found");
        }
        java.lang.String strSubstring2 = str.substring(i_renamed, iIndexOf2);
        if (!getEncoding().equalsIgnoreCase(strSubstring2)) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("This codec cannot decode ");
            stringBuffer.append(strSubstring2);
            stringBuffer.append(" encoded content");
            throw new org.apache.commons.codec.DecoderException(stringBuffer.toString());
        }
        int i2 = iIndexOf2 + 1;
        return new java.lang.String(doDecoding(org.apache.commons.codec.binary.StringUtils.getBytesUsAscii(str.substring(i2, str.indexOf(63, i2)))), strSubstring);
    }
}
