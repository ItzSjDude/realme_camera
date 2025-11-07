package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public class RefinedSoundex implements org.apache.commons.codec.StringEncoder {
    private final char[] soundexMapping;
    public static final java.lang.String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final org.apache.commons.codec.language.RefinedSoundex US_ENGLISH = new org.apache.commons.codec.language.RefinedSoundex();

    public RefinedSoundex() {
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public RefinedSoundex(char[] cArr) {
        this.soundexMapping = new char[cArr.length];
        java.lang.System.arraycopy(cArr, 0, this.soundexMapping, 0, cArr.length);
    }

    public RefinedSoundex(java.lang.String str) {
        this.soundexMapping = str.toCharArray();
    }

    public int difference(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        return org.apache.commons.codec.language.SoundexUtils.difference(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof java.lang.String)) {
            throw new org.apache.commons.codec.EncoderException("Parameter supplied to RefinedSoundex encode is_renamed not of_renamed type java.lang.String");
        }
        return soundex((java.lang.String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return soundex(str);
    }

    char getMappingCode(char c2) {
        if (java.lang.Character.isLetter(c2)) {
            return this.soundexMapping[java.lang.Character.toUpperCase(c2) - 'A_renamed'];
        }
        return (char) 0;
    }

    public java.lang.String soundex(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String strClean = org.apache.commons.codec.language.SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(strClean.charAt(0));
        char c2 = '*';
        for (int i_renamed = 0; i_renamed < strClean.length(); i_renamed++) {
            char mappingCode = getMappingCode(strClean.charAt(i_renamed));
            if (mappingCode != c2) {
                if (mappingCode != 0) {
                    stringBuffer.append(mappingCode);
                }
                c2 = mappingCode;
            }
        }
        return stringBuffer.toString();
    }
}
