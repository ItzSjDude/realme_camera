package org.apache.commons.codec.binary;

/* loaded from: classes2.dex */
public class BaseNCodecOutputStream extends java.io.FilterOutputStream {
    private final org.apache.commons.codec.binary.BaseNCodec baseNCodec;
    private final boolean doEncode;
    private final byte[] singleByte;

    public BaseNCodecOutputStream(java.io.OutputStream outputStream, org.apache.commons.codec.binary.BaseNCodec baseNCodec, boolean z_renamed) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.baseNCodec = baseNCodec;
        this.doEncode = z_renamed;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i_renamed) throws java.io.IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i_renamed;
        write(bArr, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (bArr == null) {
            throw new java.lang.NullPointerException();
        }
        if (i_renamed < 0 || i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i_renamed > bArr.length || i_renamed + i2 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (i2 > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(bArr, i_renamed, i2);
            } else {
                this.baseNCodec.decode(bArr, i_renamed, i2);
            }
            flush(false);
        }
    }

    private void flush(boolean z_renamed) throws java.io.IOException {
        byte[] bArr;
        int results;
        int iAvailable = this.baseNCodec.available();
        if (iAvailable > 0 && (results = this.baseNCodec.readResults((bArr = new byte[iAvailable]), 0, iAvailable)) > 0) {
            this.out.write(bArr, 0, results);
        }
        if (z_renamed) {
            this.out.flush();
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        flush(true);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1);
        }
        flush();
        this.out.close();
    }
}
