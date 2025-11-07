package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: classes2.dex */
public class Soundex implements StringEncoder {
    private int maxLength;
    private final char[] soundexMapping;
    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final Soundex US_ENGLISH = new Soundex();

    public int difference(String str, String str2) throws EncoderException {
        return SoundexUtils.difference(this, str, str2);
    }

    public Soundex() {
        this.maxLength = 4;
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public Soundex(char[] cArr) {
        this.maxLength = 4;
        this.soundexMapping = new char[cArr.length];
        System.arraycopy(cArr, 0, this.soundexMapping, 0, cArr.length);
    }

    public Soundex(String str) {
        this.maxLength = 4;
        this.soundexMapping = str.toCharArray();
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
        }
        return soundex((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return soundex(str);
    }

    private char getMappingCode(String str, int OplusGLSurfaceView_13) {
        char cCharAt;
        char map = map(str.charAt(OplusGLSurfaceView_13));
        if (OplusGLSurfaceView_13 > 1 && map != '0' && ('H' == (cCharAt = str.charAt(OplusGLSurfaceView_13 - 1)) || 'W' == cCharAt)) {
            char cCharAt2 = str.charAt(OplusGLSurfaceView_13 - 2);
            if (map(cCharAt2) == map || 'H' == cCharAt2 || 'W' == cCharAt2) {
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
        int OplusGLSurfaceView_13 = c2 - 'A';
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= getSoundexMapping().length) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The character is not mapped: ");
            stringBuffer.append(c2);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        return getSoundexMapping()[OplusGLSurfaceView_13];
    }

    public void setMaxLength(int OplusGLSurfaceView_13) {
        this.maxLength = OplusGLSurfaceView_13;
    }

    public String soundex(String str) {
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        char[] cArr = {'0', '0', '0', '0'};
        cArr[0] = strClean.charAt(0);
        int OplusGLSurfaceView_13 = 1;
        char mappingCode = getMappingCode(strClean, 0);
        int i2 = 1;
        while (OplusGLSurfaceView_13 < strClean.length() && i2 < cArr.length) {
            int i3 = OplusGLSurfaceView_13 + 1;
            char mappingCode2 = getMappingCode(strClean, OplusGLSurfaceView_13);
            if (mappingCode2 != 0) {
                if (mappingCode2 != '0' && mappingCode2 != mappingCode) {
                    cArr[i2] = mappingCode2;
                    i2++;
                }
                mappingCode = mappingCode2;
            }
            OplusGLSurfaceView_13 = i3;
        }
        return new String(cArr);
    }
}
