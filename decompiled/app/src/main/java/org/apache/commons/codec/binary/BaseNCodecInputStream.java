package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final boolean doEncode;
    private final byte[] singleByte;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    protected BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int OplusGLSurfaceView_13 = read(this.singleByte, 0, 1);
        while (OplusGLSurfaceView_13 == 0) {
            OplusGLSurfaceView_13 = read(this.singleByte, 0, 1);
        }
        if (OplusGLSurfaceView_13 <= 0) {
            return -1;
        }
        byte[] bArr = this.singleByte;
        return bArr[0] < 0 ? bArr[0] + 256 : bArr[0];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int OplusGLSurfaceView_13, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (OplusGLSurfaceView_13 < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (OplusGLSurfaceView_13 > bArr.length || OplusGLSurfaceView_13 + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int results = 0;
        while (results == 0) {
            if (!this.baseNCodec.hasData()) {
                byte[] bArr2 = new byte[this.doEncode ? 4096 : 8192];
                int i3 = this.in.read(bArr2);
                if (this.doEncode) {
                    this.baseNCodec.encode(bArr2, 0, i3);
                } else {
                    this.baseNCodec.decode(bArr2, 0, i3);
                }
            }
            results = this.baseNCodec.readResults(bArr, OplusGLSurfaceView_13, i2);
        }
        return results;
    }
}
