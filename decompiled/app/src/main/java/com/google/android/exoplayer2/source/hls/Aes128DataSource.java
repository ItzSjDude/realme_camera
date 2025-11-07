package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
class Aes128DataSource implements com.google.android.exoplayer2.upstream.DataSource {
    private javax.crypto.CipherInputStream cipherInputStream;
    private final byte[] encryptionIv;
    private final byte[] encryptionKey;
    private final com.google.android.exoplayer2.upstream.DataSource upstream;

    public Aes128DataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.upstream = dataSource;
        this.encryptionKey = bArr;
        this.encryptionIv = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.upstream.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public final long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.security.InvalidKeyException, java.io.IOException, java.security.InvalidAlgorithmParameterException {
        try {
            javax.crypto.Cipher cipherInstance = getCipherInstance();
            try {
                cipherInstance.init(2, new javax.crypto.spec.SecretKeySpec(this.encryptionKey, "AES"), new javax.crypto.spec.IvParameterSpec(this.encryptionIv));
                com.google.android.exoplayer2.upstream.DataSourceInputStream dataSourceInputStream = new com.google.android.exoplayer2.upstream.DataSourceInputStream(this.upstream, dataSpec);
                this.cipherInputStream = new javax.crypto.CipherInputStream(dataSourceInputStream, cipherInstance);
                dataSourceInputStream.open();
                return -1L;
            } catch (java.security.InvalidAlgorithmParameterException | java.security.InvalidKeyException e_renamed) {
                throw new java.lang.RuntimeException(e_renamed);
            }
        } catch (java.security.NoSuchAlgorithmException | javax.crypto.NoSuchPaddingException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public final int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.cipherInputStream);
        int i3 = this.cipherInputStream.read(bArr, i_renamed, i2);
        if (i3 < 0) {
            return -1;
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final android.net.Uri getUri() {
        return this.upstream.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        if (this.cipherInputStream != null) {
            this.cipherInputStream = null;
            this.upstream.close();
        }
    }

    protected javax.crypto.Cipher getCipherInstance() throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException {
        return javax.crypto.Cipher.getInstance("AES/CBC/PKCS7Padding");
    }
}
