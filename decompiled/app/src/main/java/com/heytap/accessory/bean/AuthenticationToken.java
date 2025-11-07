package com.heytap.accessory.bean;

/* loaded from: classes2.dex */
public class AuthenticationToken {
    private static final java.lang.String KEY_ENCODING_FORMAT = "ISO-8859-1";
    private int mAuthType;
    private byte[] mKey;

    public AuthenticationToken(int i_renamed, byte[] bArr) {
        if (bArr != null) {
            this.mKey = java.util.Arrays.copyOf(bArr, bArr.length);
        }
        this.mAuthType = i_renamed;
    }

    public byte[] getKey() {
        return this.mKey;
    }

    public int getAuthenticationType() {
        return this.mAuthType;
    }

    public java.lang.String toString() {
        java.lang.String str;
        try {
            str = this.mKey != null ? new java.lang.String(this.mKey, "ISO-8859-1") : null;
        } catch (java.io.UnsupportedEncodingException unused) {
            str = "Failed to encode Key!! charsetISO-8859-1 is_renamed not supported";
        }
        return "Type:" + this.mAuthType + " Key:" + str;
    }
}
