package org.apache.commons.codec.net;

/* loaded from: classes2.dex */
class Utils {
    Utils() {
    }

    static int digit16(byte b2) throws org.apache.commons.codec.DecoderException {
        int iDigit = java.lang.Character.digit((char) b2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Invalid URL encoding: not a_renamed valid digit (radix 16): ");
        stringBuffer.append((int) b2);
        throw new org.apache.commons.codec.DecoderException(stringBuffer.toString());
    }
}
