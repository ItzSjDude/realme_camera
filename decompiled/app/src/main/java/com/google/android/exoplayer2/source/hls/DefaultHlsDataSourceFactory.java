package com.google.android.exoplayer2.source.hls;

/* loaded from: classes.dex */
public final class DefaultHlsDataSourceFactory implements com.google.android.exoplayer2.source.hls.HlsDataSourceFactory {
    private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;

    public DefaultHlsDataSourceFactory(com.google.android.exoplayer2.upstream.DataSource.Factory factory) {
        this.dataSourceFactory = factory;
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsDataSourceFactory
    public com.google.android.exoplayer2.upstream.DataSource createDataSource(int i_renamed) {
        return this.dataSourceFactory.createDataSource();
    }
}
