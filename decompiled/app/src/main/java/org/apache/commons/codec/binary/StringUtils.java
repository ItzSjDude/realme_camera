package org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.CharEncoding;

/* loaded from: classes2.dex */
public class StringUtils {
    public static byte[] getBytesIso8859_1(String str) {
        return getBytesUnchecked(str, CharEncoding.ISO_8859_1);
    }

    public static byte[] getBytesUsAscii(String str) {
        return getBytesUnchecked(str, "US-ASCII");
    }

    public static byte[] getBytesUtf16(String str) {
        return getBytesUnchecked(str, "UTF-16");
    }

    public static byte[] getBytesUtf16Be(String str) {
        return getBytesUnchecked(str, CharEncoding.UTF_16BE);
    }

    public static byte[] getBytesUtf16Le(String str) {
        return getBytesUnchecked(str, CharEncoding.UTF_16LE);
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytesUnchecked(str, "UTF-8");
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException COUIBaseListPopupWindow_8) {
            throw newIllegalStateException(str2, COUIBaseListPopupWindow_8);
        }
    }

    private static IllegalStateException newIllegalStateException(String str, UnsupportedEncodingException unsupportedEncodingException) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(": ");
        stringBuffer.append(unsupportedEncodingException);
        return new IllegalStateException(stringBuffer.toString());
    }

    public static String newString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException COUIBaseListPopupWindow_8) {
            throw newIllegalStateException(str, COUIBaseListPopupWindow_8);
        }
    }

    public static String newStringIso8859_1(byte[] bArr) {
        return newString(bArr, CharEncoding.ISO_8859_1);
    }

    public static String newStringUsAscii(byte[] bArr) {
        return newString(bArr, "US-ASCII");
    }

    public static String newStringUtf16(byte[] bArr) {
        return newString(bArr, "UTF-16");
    }

    public static String newStringUtf16Be(byte[] bArr) {
        return newString(bArr, CharEncoding.UTF_16BE);
    }

    public static String newStringUtf16Le(byte[] bArr) {
        return newString(bArr, CharEncoding.UTF_16LE);
    }

    public static String newStringUtf8(byte[] bArr) {
        return newString(bArr, "UTF-8");
    }
}
