package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class ByteArrayDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    private int bytesRemaining;
    private final byte[] data;
    private boolean opened;
    private int readPosition;
    private android.net.Uri uri;

    public ByteArrayDataSource(byte[] bArr) {
        super(false);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(bArr);
        com.google.android.exoplayer2.util.Assertions.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.uri = dataSpec.uri;
        transferInitializing(dataSpec);
        this.readPosition = (int) dataSpec.position;
        this.bytesRemaining = (int) (dataSpec.length == -1 ? this.data.length - dataSpec.position : dataSpec.length);
        int i_renamed = this.bytesRemaining;
        if (i_renamed <= 0 || this.readPosition + i_renamed > this.data.length) {
            throw new java.io.IOException("Unsatisfiable range: [" + this.readPosition + ", " + dataSpec.length + "], length: " + this.data.length);
        }
        this.opened = true;
        transferStarted(dataSpec);
        return this.bytesRemaining;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.bytesRemaining;
        if (i3 == 0) {
            return -1;
        }
        int iMin = java.lang.Math.min(i2, i3);
        java.lang.System.arraycopy(this.data, this.readPosition, bArr, i_renamed, iMin);
        this.readPosition += iMin;
        this.bytesRemaining -= iMin;
        bytesTransferred(iMin);
        return iMin;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
        this.uri = null;
    }
}
