package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public class Metaphone implements org.apache.commons.codec.StringEncoder {
    private static final java.lang.String FRONTV = "EIY";
    private static final java.lang.String VARSON = "CSPTG";
    private static final java.lang.String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i_renamed, int i2) {
        return i2 + 1 == i_renamed;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:132:0x0211  */
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

    private boolean isVowel(java.lang.StringBuffer stringBuffer, int i_renamed) {
        return VOWELS.indexOf(stringBuffer.charAt(i_renamed)) >= 0;
    }

    private boolean isPreviousChar(java.lang.StringBuffer stringBuffer, int i_renamed, char c2) {
        return i_renamed > 0 && i_renamed < stringBuffer.length() && stringBuffer.charAt(i_renamed - 1) == c2;
    }

    private boolean isNextChar(java.lang.StringBuffer stringBuffer, int i_renamed, char c2) {
        return i_renamed >= 0 && i_renamed < stringBuffer.length() - 1 && stringBuffer.charAt(i_renamed + 1) == c2;
    }

    private boolean regionMatch(java.lang.StringBuffer stringBuffer, int i_renamed, java.lang.String str) {
        if (i_renamed < 0 || (str.length() + i_renamed) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i_renamed, str.length() + i_renamed).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof java.lang.String)) {
            throw new org.apache.commons.codec.EncoderException("Parameter supplied to Metaphone encode is_renamed not of_renamed type java.lang.String");
        }
        return metaphone((java.lang.String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return metaphone(str);
    }

    public boolean isMetaphoneEqual(java.lang.String str, java.lang.String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i_renamed) {
        this.maxCodeLen = i_renamed;
    }
}
