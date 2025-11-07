package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes.dex */
public final class AesCipherDataSink implements com.google.android.exoplayer2.upstream.DataSink {
    private com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher cipher;
    private final byte[] scratch;
    private final byte[] secretKey;
    private final com.google.android.exoplayer2.upstream.DataSink wrappedDataSink;

    public AesCipherDataSink(byte[] bArr, com.google.android.exoplayer2.upstream.DataSink dataSink) {
        this(bArr, dataSink, null);
    }

    public AesCipherDataSink(byte[] bArr, com.google.android.exoplayer2.upstream.DataSink dataSink, byte[] bArr2) {
        this.wrappedDataSink = dataSink;
        this.secretKey = bArr;
        this.scratch = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.wrappedDataSink.open(dataSpec);
        this.cipher = new com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher(1, this.secretKey, com.google.android.exoplayer2.upstream.crypto.CryptoUtil.getFNV64Hash(dataSpec.key), dataSpec.absoluteStreamPosition);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void write(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (this.scratch == null) {
            this.cipher.updateInPlace(bArr, i_renamed, i2);
            this.wrappedDataSink.write(bArr, i_renamed, i2);
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            int iMin = java.lang.Math.min(i2 - i3, this.scratch.length);
            this.cipher.update(bArr, i_renamed + i3, iMin, this.scratch, 0);
            this.wrappedDataSink.write(this.scratch, 0, iMin);
            i3 += iMin;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSink
    public void close() throws java.io.IOException {
        this.cipher = null;
        this.wrappedDataSink.close();
    }
}
