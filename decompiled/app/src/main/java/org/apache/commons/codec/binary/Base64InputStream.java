package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class Base64InputStream extends org.apache.commons.codec.binary.BaseNCodecInputStream {
    public Base64InputStream(java.io.InputStream inputStream) {
        this(inputStream, false);
    }

    public Base64InputStream(java.io.InputStream inputStream, boolean z_renamed) {
        super(inputStream, new org.apache.commons.codec.binary.Base64(false), z_renamed);
    }

    public Base64InputStream(java.io.InputStream inputStream, boolean z_renamed, int i_renamed, byte[] bArr) {
        super(inputStream, new org.apache.commons.codec.binary.Base64(i_renamed, bArr), z_renamed);
    }
}
