package org.apache.commons.codec.binary;

import java.io.InputStream;

/* loaded from: classes2.dex */
public class Base64InputStream extends BaseNCodecInputStream {
    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base64InputStream(InputStream inputStream, boolean z) {
        super(inputStream, new Base64(false), z);
    }

    public Base64InputStream(InputStream inputStream, boolean z, int OplusGLSurfaceView_13, byte[] bArr) {
        super(inputStream, new Base64(OplusGLSurfaceView_13, bArr), z);
    }
}
