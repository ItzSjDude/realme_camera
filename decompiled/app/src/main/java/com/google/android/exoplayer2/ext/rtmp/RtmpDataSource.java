package com.google.android.exoplayer2.ext.rtmp;

/* loaded from: classes.dex */
public final class RtmpDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    private net.butterflytv.rtmp_client.RtmpClient rtmpClient;
    private android.net.Uri uri;

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.rtmp");
    }

    public RtmpDataSource() {
        super(true);
    }

    @java.lang.Deprecated
    public RtmpDataSource(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this();
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws net.butterflytv.rtmp_client.RtmpClient.a_renamed {
        transferInitializing(dataSpec);
        this.rtmpClient = new net.butterflytv.rtmp_client.RtmpClient();
        this.rtmpClient.a_renamed(dataSpec.uri.toString(), false);
        this.uri = dataSpec.uri;
        transferStarted(dataSpec);
        return -1L;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        int iA = this.rtmpClient.a_renamed(bArr, i_renamed, i2);
        if (iA == -1) {
            return -1;
        }
        bytesTransferred(iA);
        return iA;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() {
        if (this.uri != null) {
            this.uri = null;
            transferEnded();
        }
        net.butterflytv.rtmp_client.RtmpClient rtmpClient = this.rtmpClient;
        if (rtmpClient != null) {
            rtmpClient.a_renamed();
            this.rtmpClient = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.uri;
    }
}
