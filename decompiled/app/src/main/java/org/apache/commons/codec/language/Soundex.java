package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public class Soundex implements org.apache.commons.codec.StringEncoder {
    private int maxLength;
    private final char[] soundexMapping;
    public static final java.lang.String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final org.apache.commons.codec.language.Soundex US_ENGLISH = new org.apache.commons.codec.language.Soundex();

    public int difference(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        return org.apache.commons.codec.language.SoundexUtils.difference(this, str, str2);
    }

    public Soundex() {
        this.maxLength = 4;
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public Soundex(char[] cArr) {
        this.maxLength = 4;
        this.soundexMapping = new char[cArr.length];
        java.lang.System.arraycopy(cArr, 0, this.soundexMapping, 0, cArr.length);
    }

    public Soundex(java.lang.String str) {
        this.maxLength = 4;
        this.soundexMapping = str.toCharArray();
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof java.lang.String)) {
            throw new org.apache.commons.codec.EncoderException("Parameter supplied to Soundex encode is_renamed not of_renamed type java.lang.String");
        }
        return soundex((java.lang.String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return soundex(str);
    }

    private char getMappingCode(java.lang.String str, int i_renamed) {
        char cCharAt;
        char map = map(str.charAt(i_renamed));
        if (i_renamed > 1 && map != '0' && ('H_renamed' == (cCharAt = str.charAt(i_renamed - 1)) || 'W_renamed' == cCharAt)) {
            char cCharAt2 = str.charAt(i_renamed - 2);
            if (map(cCharAt2) == map || 'H_renamed' == cCharAt2 || 'W_renamed' == cCharAt2) {
                return (char) 0;
            }
        }
        return map;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    private char[] getSoundexMapping() {
        return this.soundexMapping;
    }

    private char map(char c2) {
        int i_renamed = c2 - 'A_renamed';
        if (i_renamed < 0 || i_renamed >= getSoundexMapping().length) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append("The character is_renamed not mapped: ");
            stringBuffer.append(c2);
            throw new java.lang.IllegalArgumentException(stringBuffer.toString());
        }
        return getSoundexMapping()[i_renamed];
    }

    public void setMaxLength(int i_renamed) {
        this.maxLength = i_renamed;
    }

    public java.lang.String soundex(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String strClean = org.apache.commons.codec.language.SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = strClean.charAt(0);
        int i_renamed = 1;
        char mappingCode = getMappingCode(strClean, 0);
        int i2 = 1;
        while (i_renamed < strClean.length() && i2 < cArr.length) {
            int i3 = i_renamed + 1;
            char mappingCode2 = getMappingCode(strClean, i_renamed);
            if (mappingCode2 != 0) {
                if (mappingCode2 != '0' && mappingCode2 != mappingCode) {
                    cArr[i2] = mappingCode2;
                    i2++;
                }
                mappingCode = mappingCode2;
            }
            i_renamed = i3;
        }
        return new java.lang.String(cArr);
    }
}
