package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DefaultDataSourceFactory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
    private final com.google.android.exoplayer2.upstream.DataSource.Factory baseDataSourceFactory;
    private final android.content.Context context;
    private final com.google.android.exoplayer2.upstream.TransferListener listener;

    public DefaultDataSourceFactory(android.content.Context context, java.lang.String str) {
        this(context, str, (com.google.android.exoplayer2.upstream.TransferListener) null);
    }

    public DefaultDataSourceFactory(android.content.Context context, java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(context, transferListener, new com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory(str, transferListener));
    }

    public DefaultDataSourceFactory(android.content.Context context, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this(context, (com.google.android.exoplayer2.upstream.TransferListener) null, factory);
    }

    public DefaultDataSourceFactory(android.content.Context context, com.google.android.exoplayer2.upstream.TransferListener transferListener, com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this.context = context.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSourceFactory = factory;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public com.google.android.exoplayer2.upstream.DefaultDataSource createDataSource() {
        com.google.android.exoplayer2.upstream.DefaultDataSource defaultDataSource = new com.google.android.exoplayer2.upstream.DefaultDataSource(this.context, this.baseDataSourceFactory.createDataSource());
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.listener;
        if (transferListener != null) {
            defaultDataSource.addTransferListener(transferListener);
        }
        return defaultDataSource;
    }
}
