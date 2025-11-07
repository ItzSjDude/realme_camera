package org.apache.commons.codec.binary;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public class Base32OutputStream extends BaseNCodecOutputStream {
    public Base32OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream, new Base32(false), z);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z, int OplusGLSurfaceView_13, byte[] bArr) {
        super(outputStream, new Base32(OplusGLSurfaceView_13, bArr), z);
    }
}
