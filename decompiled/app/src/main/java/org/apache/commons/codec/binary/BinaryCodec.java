package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class BinaryCodec implements org.apache.commons.codec.BinaryDecoder, org.apache.commons.codec.BinaryEncoder {
    private static final int BIT_0 = 1;
    private static final int BIT_1 = 2;
    private static final int BIT_2 = 4;
    private static final int BIT_3 = 8;
    private static final int BIT_4 = 16;
    private static final int BIT_5 = 32;
    private static final int BIT_6 = 64;
    private static final int BIT_7 = 128;
    private static final char[] EMPTY_CHAR_ARRAY = new char[0];
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int[] BITS = {1, 2, 4, 8, 16, 32, 64, 128};

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return toAsciiBytes(bArr);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof byte[])) {
            throw new org.apache.commons.codec.EncoderException("argument not a_renamed byte array");
        }
        return toAsciiChars((byte[]) obj);
    }

    @Override // org.apache.commons.codec.Decoder
    public java.lang.Object decode(java.lang.Object obj) throws org.apache.commons.codec.DecoderException {
        if (obj == null) {
            return EMPTY_BYTE_ARRAY;
        }
        if (obj instanceof byte[]) {
            return fromAscii((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return fromAscii((char[]) obj);
        }
        if (obj instanceof java.lang.String) {
            return fromAscii(((java.lang.String) obj).toCharArray());
        }
        throw new org.apache.commons.codec.DecoderException("argument not a_renamed byte array");
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        return fromAscii(bArr);
    }

    public byte[] toByteArray(java.lang.String str) {
        if (str == null) {
            return EMPTY_BYTE_ARRAY;
        }
        return fromAscii(str.toCharArray());
    }

    public static byte[] fromAscii(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[cArr.length >> 3];
        int length = cArr.length - 1;
        int i_renamed = 0;
        while (i_renamed < bArr.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 < iArr.length) {
                    if (cArr[length - i2] == '1') {
                        bArr[i_renamed] = (byte) (iArr[i2] | bArr[i_renamed]);
                    }
                    i2++;
                }
            }
            i_renamed++;
            length -= 8;
        }
        return bArr;
    }

    public static byte[] fromAscii(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length >> 3];
        int length = bArr.length - 1;
        int i_renamed = 0;
        while (i_renamed < bArr2.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 < iArr.length) {
                    if (bArr[length - i2] == 49) {
                        bArr2[i_renamed] = (byte) (iArr[i2] | bArr2[i_renamed]);
                    }
                    i2++;
                }
            }
            i_renamed++;
            length -= 8;
        }
        return bArr2;
    }

    private static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] toAsciiBytes(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length << 3];
        int length = bArr2.length - 1;
        int i_renamed = 0;
        while (i_renamed < bArr.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 < iArr.length) {
                    if ((iArr[i2] & bArr[i_renamed]) == 0) {
                        bArr2[length - i2] = 48;
                    } else {
                        bArr2[length - i2] = 49;
                    }
                    i2++;
                }
            }
            i_renamed++;
            length -= 8;
        }
        return bArr2;
    }

    public static char[] toAsciiChars(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[bArr.length << 3];
        int length = cArr.length - 1;
        int i_renamed = 0;
        while (i_renamed < bArr.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 < iArr.length) {
                    if ((iArr[i2] & bArr[i_renamed]) == 0) {
                        cArr[length - i2] = '0';
                    } else {
                        cArr[length - i2] = '1';
                    }
                    i2++;
                }
            }
            i_renamed++;
            length -= 8;
        }
        return cArr;
    }

    public static java.lang.String toAsciiString(byte[] bArr) {
        return new java.lang.String(toAsciiChars(bArr));
    }
}
