package org.apache.commons.codec.binary;

import java.io.InputStream;

/* loaded from: classes2.dex */
public class Base32InputStream extends BaseNCodecInputStream {
    public Base32InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base32InputStream(InputStream inputStream, boolean z) {
        super(inputStream, new Base32(false), z);
    }

    public Base32InputStream(InputStream inputStream, boolean z, int OplusGLSurfaceView_13, byte[] bArr) {
        super(inputStream, new Base32(OplusGLSurfaceView_13, bArr), z);
    }
}
