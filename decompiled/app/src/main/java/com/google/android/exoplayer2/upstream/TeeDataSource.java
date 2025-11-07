package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class TeeDataSource implements com.google.android.exoplayer2.upstream.DataSource {
    private long bytesRemaining;
    private final com.google.android.exoplayer2.upstream.DataSink dataSink;
    private boolean dataSinkNeedsClosing;
    private final com.google.android.exoplayer2.upstream.DataSource upstream;

    public TeeDataSource(com.google.android.exoplayer2.upstream.DataSource dataSource, com.google.android.exoplayer2.upstream.DataSink dataSink) {
        this.upstream = (com.google.android.exoplayer2.upstream.DataSource) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSource);
        this.dataSink = (com.google.android.exoplayer2.upstream.DataSink) com.google.android.exoplayer2.util.Assertions.checkNotNull(dataSink);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.upstream.addTransferListener(transferListener);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.bytesRemaining = this.upstream.open(dataSpec);
        if (this.bytesRemaining == 0) {
            return 0L;
        }
        if (dataSpec.length == -1) {
            long j_renamed = this.bytesRemaining;
            if (j_renamed != -1) {
                dataSpec = dataSpec.subrange(0L, j_renamed);
            }
        }
        this.dataSinkNeedsClosing = true;
        this.dataSink.open(dataSpec);
        return this.bytesRemaining;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (this.bytesRemaining == 0) {
            return -1;
        }
        int i3 = this.upstream.read(bArr, i_renamed, i2);
        if (i3 > 0) {
            this.dataSink.write(bArr, i_renamed, i3);
            long j_renamed = this.bytesRemaining;
            if (j_renamed != -1) {
                this.bytesRemaining = j_renamed - i3;
            }
        }
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
        try {
            this.upstream.close();
        } finally {
            if (this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                this.dataSink.close();
            }
        }
    }
}
