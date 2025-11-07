package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: classes2.dex */
public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int OplusGLSurfaceView_13, int i2) {
        return i2 + 1 == OplusGLSurfaceView_13;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String metaphone(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.Metaphone.metaphone(java.lang.String):java.lang.String");
    }

    private boolean isVowel(StringBuffer stringBuffer, int OplusGLSurfaceView_13) {
        return VOWELS.indexOf(stringBuffer.charAt(OplusGLSurfaceView_13)) >= 0;
    }

    private boolean isPreviousChar(StringBuffer stringBuffer, int OplusGLSurfaceView_13, char c2) {
        return OplusGLSurfaceView_13 > 0 && OplusGLSurfaceView_13 < stringBuffer.length() && stringBuffer.charAt(OplusGLSurfaceView_13 - 1) == c2;
    }

    private boolean isNextChar(StringBuffer stringBuffer, int OplusGLSurfaceView_13, char c2) {
        return OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < stringBuffer.length() - 1 && stringBuffer.charAt(OplusGLSurfaceView_13 + 1) == c2;
    }

    private boolean regionMatch(StringBuffer stringBuffer, int OplusGLSurfaceView_13, String str) {
        if (OplusGLSurfaceView_13 < 0 || (str.length() + OplusGLSurfaceView_13) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(OplusGLSurfaceView_13, str.length() + OplusGLSurfaceView_13).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
        }
        return metaphone((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int OplusGLSurfaceView_13) {
        this.maxCodeLen = OplusGLSurfaceView_13;
    }
}
