package org.apache.commons.codec.language;

/* loaded from: classes2.dex */
public abstract class AbstractCaverphone implements org.apache.commons.codec.StringEncoder {
    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (!(obj instanceof java.lang.String)) {
            throw new org.apache.commons.codec.EncoderException("Parameter supplied to Caverphone encode is_renamed not of_renamed type java.lang.String");
        }
        return encode((java.lang.String) obj);
    }

    public boolean isEncodeEqual(java.lang.String str, java.lang.String str2) throws org.apache.commons.codec.EncoderException {
        return encode(str).equals(encode(str2));
    }
}
