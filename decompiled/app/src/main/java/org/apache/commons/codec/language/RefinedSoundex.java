package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: classes2.dex */
public class RefinedSoundex implements StringEncoder {
    private final char[] soundexMapping;
    public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();

    public RefinedSoundex() {
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public RefinedSoundex(char[] cArr) {
        this.soundexMapping = new char[cArr.length];
        System.arraycopy(cArr, 0, this.soundexMapping, 0, cArr.length);
    }

    public RefinedSoundex(String str) {
        this.soundexMapping = str.toCharArray();
    }

    public int difference(String str, String str2) throws EncoderException {
        return SoundexUtils.difference(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
        }
        return soundex((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return soundex(str);
    }

    char getMappingCode(char c2) {
        if (Character.isLetter(c2)) {
            return this.soundexMapping[Character.toUpperCase(c2) - 'A'];
        }
        return (char) 0;
    }

    public String soundex(String str) {
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strClean.charAt(0));
        char c2 = '*';
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strClean.length(); OplusGLSurfaceView_13++) {
            char mappingCode = getMappingCode(strClean.charAt(OplusGLSurfaceView_13));
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
