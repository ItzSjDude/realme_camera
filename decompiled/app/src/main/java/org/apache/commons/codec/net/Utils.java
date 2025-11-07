package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

/* loaded from: classes2.dex */
class Utils {
    Utils() {
    }

    static int digit16(byte b2) throws DecoderException {
        int iDigit = Character.digit((char) b2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid URL encoding: not PlatformImplementations.kt_3 valid digit (radix 16): ");
        stringBuffer.append((int) b2);
        throw new DecoderException(stringBuffer.toString());
    }
}
