package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class BaseNCodecInputStream extends java.io.FilterInputStream {
    private final org.apache.commons.codec.binary.BaseNCodec baseNCodec;
    private final boolean doEncode;
    private final byte[] singleByte;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    protected BaseNCodecInputStream(java.io.InputStream inputStream, org.apache.commons.codec.binary.BaseNCodec baseNCodec, boolean z_renamed) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.doEncode = z_renamed;
        this.baseNCodec = baseNCodec;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int i_renamed = read(this.singleByte, 0, 1);
        while (i_renamed == 0) {
            i_renamed = read(this.singleByte, 0, 1);
        }
        if (i_renamed <= 0) {
            return -1;
        }
        byte[] bArr = this.singleByte;
        return bArr[0] < 0 ? bArr[0] + 256 : bArr[0];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (bArr == null) {
            throw new java.lang.NullPointerException();
        }
        if (i_renamed < 0 || i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i_renamed > bArr.length || i_renamed + i2 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int results = 0;
        while (results == 0) {
            if (!this.baseNCodec.hasData()) {
                byte[] bArr2 = new byte[this.doEncode ? 4096 : 8192];
                int i3 = this.in_renamed.read(bArr2);
                if (this.doEncode) {
                    this.baseNCodec.encode(bArr2, 0, i3);
                } else {
                    this.baseNCodec.decode(bArr2, 0, i3);
                }
            }
            results = this.baseNCodec.readResults(bArr, i_renamed, i2);
        }
        return results;
    }
}
