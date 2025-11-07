package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class Base64OutputStream extends org.apache.commons.codec.binary.BaseNCodecOutputStream {
    public Base64OutputStream(java.io.OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base64OutputStream(java.io.OutputStream outputStream, boolean z_renamed) {
        super(outputStream, new org.apache.commons.codec.binary.Base64(false), z_renamed);
    }

    public Base64OutputStream(java.io.OutputStream outputStream, boolean z_renamed, int i_renamed, byte[] bArr) {
        super(outputStream, new org.apache.commons.codec.binary.Base64(i_renamed, bArr), z_renamed);
    }
}
