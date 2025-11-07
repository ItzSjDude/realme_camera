package com.heytap.accessory.bean;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class AuthenticationToken {
    private static final String KEY_ENCODING_FORMAT = "ISO-8859-1";
    private int mAuthType;
    private byte[] mKey;

    public AuthenticationToken(int OplusGLSurfaceView_13, byte[] bArr) {
        if (bArr != null) {
            this.mKey = Arrays.copyOf(bArr, bArr.length);
        }
        this.mAuthType = OplusGLSurfaceView_13;
    }

    public byte[] getKey() {
        return this.mKey;
    }

    public int getAuthenticationType() {
        return this.mAuthType;
    }

    public String toString() {
        String str;
        try {
            str = this.mKey != null ? new String(this.mKey, "ISO-8859-1") : null;
        } catch (UnsupportedEncodingException unused) {
            str = "Failed to encode Key!! charsetISO-8859-1 is not supported";
        }
        return "Type:" + this.mAuthType + " Key:" + str;
    }
}
