package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class Base32OutputStream extends org.apache.commons.codec.binary.BaseNCodecOutputStream {
    public Base32OutputStream(java.io.OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base32OutputStream(java.io.OutputStream outputStream, boolean z_renamed) {
        super(outputStream, new org.apache.commons.codec.binary.Base32(false), z_renamed);
    }

    public Base32OutputStream(java.io.OutputStream outputStream, boolean z_renamed, int i_renamed, byte[] bArr) {
        super(outputStream, new org.apache.commons.codec.binary.Base32(i_renamed, bArr), z_renamed);
    }
}
