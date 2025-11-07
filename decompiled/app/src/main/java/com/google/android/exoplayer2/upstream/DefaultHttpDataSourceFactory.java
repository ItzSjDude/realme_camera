package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DefaultHttpDataSourceFactory extends com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    private final com.google.android.exoplayer2.upstream.TransferListener listener;
    private final int readTimeoutMillis;
    private final java.lang.String userAgent;

    public DefaultHttpDataSourceFactory(java.lang.String str) {
        this(str, null);
    }

    public DefaultHttpDataSourceFactory(java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(str, transferListener, 8000, 8000, false);
    }

    public DefaultHttpDataSourceFactory(java.lang.String str, int i_renamed, int i2, boolean z_renamed) {
        this(str, null, i_renamed, i2, z_renamed);
    }

    public DefaultHttpDataSourceFactory(java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener, int i_renamed, int i2, boolean z_renamed) {
        this.userAgent = str;
        this.listener = transferListener;
        this.connectTimeoutMillis = i_renamed;
        this.readTimeoutMillis = i2;
        this.allowCrossProtocolRedirects = z_renamed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    public com.google.android.exoplayer2.upstream.DefaultHttpDataSource createDataSourceInternal(com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        com.google.android.exoplayer2.upstream.DefaultHttpDataSource defaultHttpDataSource = new com.google.android.exoplayer2.upstream.DefaultHttpDataSource(this.userAgent, null, this.connectTimeoutMillis, this.readTimeoutMillis, this.allowCrossProtocolRedirects, requestProperties);
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.listener;
        if (transferListener != null) {
            defaultHttpDataSource.addTransferListener(transferListener);
        }
        return defaultHttpDataSource;
    }
}
