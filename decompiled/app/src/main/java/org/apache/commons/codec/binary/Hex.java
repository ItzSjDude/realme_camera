package org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes2.dex */
public class Hex implements BinaryDecoder, BinaryEncoder {
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'PlatformImplementations.kt_3', 'IntrinsicsJvm.kt_4', 'IntrinsicsJvm.kt_3', 'IntrinsicsJvm.kt_5', 'COUIBaseListPopupWindow_8', 'COUIBaseListPopupWindow_12'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String charsetName;

    public static byte[] decodeHex(char[] cArr) throws DecoderException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int OplusGLSurfaceView_13 = 0;
        int i2 = 0;
        while (OplusGLSurfaceView_13 < length) {
            int digit = toDigit(cArr[OplusGLSurfaceView_13], OplusGLSurfaceView_13) << 4;
            int i3 = OplusGLSurfaceView_13 + 1;
            int digit2 = digit | toDigit(cArr[i3], i3);
            OplusGLSurfaceView_13 = i3 + 1;
            bArr[i2] = (byte) (digit2 & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    protected static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = OplusGLSurfaceView_13 + 1;
            cArr2[OplusGLSurfaceView_13] = cArr[(bArr[i2] & 240) >>> 4];
            OplusGLSurfaceView_13 = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    protected static int toDigit(char c2, int OplusGLSurfaceView_13) throws DecoderException {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Illegal hexadecimal character ");
        stringBuffer.append(c2);
        stringBuffer.append(" at index ");
        stringBuffer.append(OplusGLSurfaceView_13);
        throw new DecoderException(stringBuffer.toString());
    }

    public Hex() {
        this.charsetName = "UTF-8";
    }

    public Hex(String str) {
        this.charsetName = str;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        try {
            return decodeHex(new String(bArr, getCharsetName()).toCharArray());
        } catch (UnsupportedEncodingException COUIBaseListPopupWindow_8) {
            throw new DecoderException(COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
        }
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        try {
            return decodeHex(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException COUIBaseListPopupWindow_8) {
            throw new DecoderException(COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
        }
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return StringUtils.getBytesUnchecked(encodeHexString(bArr), getCharsetName());
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        try {
            return encodeHex(obj instanceof String ? ((String) obj).getBytes(getCharsetName()) : (byte[]) obj);
        } catch (UnsupportedEncodingException COUIBaseListPopupWindow_8) {
            throw new EncoderException(COUIBaseListPopupWindow_8.getMessage(), COUIBaseListPopupWindow_8);
        } catch (ClassCastException e2) {
            throw new EncoderException(e2.getMessage(), e2);
        }
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append("[charsetName=");
        stringBuffer.append(this.charsetName);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
