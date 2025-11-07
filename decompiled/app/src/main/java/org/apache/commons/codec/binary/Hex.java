package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class Hex implements org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.BinaryEncoder {
    public static final java.lang.String DEFAULT_CHARSET_NAME = "UTF-8";
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a_renamed', 'b_renamed', 'c_renamed', 'd_renamed', 'e_renamed', 'f_renamed'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A_renamed', 'B_renamed', 'C_renamed', 'D_renamed', 'E_renamed', 'F_renamed'};
    private final java.lang.String charsetName;

    public static byte[] decodeHex(char[] cArr) throws org.apache.commons.codec.DecoderException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new org.apache.commons.codec.DecoderException("Odd number of_renamed characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < length) {
            int digit = toDigit(cArr[i_renamed], i_renamed) << 4;
            int i3 = i_renamed + 1;
            int digit2 = digit | toDigit(cArr[i3], i3);
            i_renamed = i3 + 1;
            bArr[i2] = (byte) (digit2 & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static char[] encodeHex(byte[] bArr, boolean z_renamed) {
        return encodeHex(bArr, z_renamed ? DIGITS_LOWER : DIGITS_UPPER);
    }

    protected static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i_renamed = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i_renamed + 1;
            cArr2[i_renamed] = cArr[(bArr[i2] & 240) >>> 4];
            i_renamed = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public static java.lang.String encodeHexString(byte[] bArr) {
        return new java.lang.String(encodeHex(bArr));
    }

    protected static int toDigit(char c2, int i_renamed) throws org.apache.commons.codec.DecoderException {
        int iDigit = java.lang.Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Illegal hexadecimal character ");
        stringBuffer.append(c2);
        stringBuffer.append(" at_renamed index ");
        stringBuffer.append(i_renamed);
        throw new org.apache.commons.codec.DecoderException(stringBuffer.toString());
    }

    public Hex() {
        this.charsetName = "UTF-8";
    }

    public Hex(java.lang.String str) {
        this.charsetName = str;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws org.apache.commons.codec.DecoderException {
        try {
            return decodeHex(new java.lang.String(bArr, getCharsetName()).toCharArray());
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new org.apache.commons.codec.DecoderException(e_renamed.getMessage(), e_renamed);
        }
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        try {
            return decodeHex(obj instanceof java.lang.String ? ((java.lang.String) obj).toCharArray() : (char[]) obj);
        } catch (java.lang.ClassCastException e_renamed) {
            throw new org.apache.commons.codec.DecoderException(e_renamed.getMessage(), e_renamed);
        }
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return org.apache.commons.codec.binary.StringUtils.getBytesUnchecked(encodeHexString(bArr), getCharsetName());
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        try {
            return encodeHex(obj instanceof java.lang.String ? ((java.lang.String) obj).getBytes(getCharsetName()) : (byte[]) obj);
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new org.apache.commons.codec.EncoderException(e_renamed.getMessage(), e_renamed);
        } catch (java.lang.ClassCastException e2) {
            throw new org.apache.commons.codec.EncoderException(e2.getMessage(), e2);
        }
    }

    public java.lang.String getCharsetName() {
        return this.charsetName;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append("[charsetName=");
        stringBuffer.append(this.charsetName);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
