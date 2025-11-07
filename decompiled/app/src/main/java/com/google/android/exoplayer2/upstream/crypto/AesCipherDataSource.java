package com.google.android.exoplayer2.upstream.crypto;

/* loaded from: classes.dex */
public final class AesCipherDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    private com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher cipher;
    private final byte[] secretKey;
    private final com.google.android.exoplayer2.upstream.DataSource upstream;

    public AesCipherDataSource(byte[] bArr, com.google.android.exoplayer2.upstream.DataSource dataSource) {
        this.upstream = dataSource;
        this.secretKey = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.upstream.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        long jOpen = this.upstream.open(dataSpec);
        this.cipher = new com.google.android.exoplayer2.upstream.crypto.AesFlushingCipher(2, this.secretKey, com.google.android.exoplayer2.upstream.crypto.CryptoUtil.getFNV64Hash(dataSpec.key), dataSpec.absoluteStreamPosition);
        return jOpen;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.upstream.read(bArr, i_renamed, i2);
        if (i3 == -1) {
            return -1;
        }
        this.cipher.updateInPlace(bArr, i_renamed, i3);
        return i3;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.upstream.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        this.cipher = null;
        this.upstream.close();
    }
}
