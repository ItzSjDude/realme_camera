package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
final class SoundexUtils {
    SoundexUtils() {
    }

    static java.lang.String clean(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i_renamed = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (java.lang.Character.isLetter(str.charAt(i2))) {
                cArr[i_renamed] = str.charAt(i2);
                i_renamed++;
            }
        }
        if (i_renamed == length) {
            return str.toUpperCase(java.util.Locale.ENGLISH);
        }
        return new java.lang.String(cArr, 0, i_renamed).toUpperCase(java.util.Locale.ENGLISH);
    }

    static int difference(org.apache.commons.codec.StringEncoder stringEncoder, java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        return differenceEncoded(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    static int differenceEncoded(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int iMin = java.lang.Math.min(str.length(), str2.length());
        int i_renamed = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            if (str.charAt(i2) == str2.charAt(i2)) {
                i_renamed++;
            }
        }
        return i_renamed;
    }
}
