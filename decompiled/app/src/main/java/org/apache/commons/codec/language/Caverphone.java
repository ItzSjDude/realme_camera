package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public class Caverphone implements org.apache.commons.codec.StringEncoder {
    private final org.apache.commons.codec.language.Caverphone2 encoder = new org.apache.commons.codec.language.Caverphone2();

    public java.lang.String caverphone(java.lang.String str) {
        return this.encoder.encode(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof java.lang.String)) {
            throw new org.apache.commons.codec.EncoderException("Parameter supplied to Caverphone encode is_renamed not of_renamed type java.lang.String");
        }
        return caverphone((java.lang.String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return caverphone(str);
    }

    public boolean isCaverphoneEqual(java.lang.String str, java.lang.String str2) {
        return caverphone(str).equals(caverphone(str2));
    }
}
