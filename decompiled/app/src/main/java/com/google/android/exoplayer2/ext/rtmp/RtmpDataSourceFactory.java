package com.google.android.exoplayer2.ext.rtmp;

/* loaded from: classes.dex */
public final class RtmpDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    private final com.google.android.exoplayer2.upstream.TransferListener listener;

    public RtmpDataSourceFactory() {
        this(null);
    }

    public RtmpDataSourceFactory(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this.listener = transferListener;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.DataSource createDataSource() {
        com.google.android.exoplayer2.ext.rtmp.RtmpDataSource rtmpDataSource = new com.google.android.exoplayer2.ext.rtmp.RtmpDataSource();
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.listener;
        if (transferListener != null) {
            rtmpDataSource.addTransferListener(transferListener);
        }
        return rtmpDataSource;
    }
}
