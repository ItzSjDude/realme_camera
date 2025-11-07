package com.oplus.tblplayer.upstream;

/* loaded from: classes2.dex */
public final class TBLHttpDataSourceFactory extends com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory {
    private final okhttp3.CacheControl cacheControl;
    private final okhttp3.Call.Factory callFactory;
    private final com.google.android.exoplayer2.upstream.TransferListener listener;
    private final java.lang.String userAgent;

    public TBLHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str) {
        this(factory, str, null, null);
    }

    public TBLHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str, okhttp3.CacheControl cacheControl) {
        this(factory, str, null, cacheControl);
    }

    public TBLHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(factory, str, transferListener, null);
    }

    public TBLHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener, okhttp3.CacheControl cacheControl) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    protected com.google.android.exoplayer2.upstream.HttpDataSource createDataSourceInternal(com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        com.oplus.tblplayer.upstream.TBLOkHttpDataSource tBLOkHttpDataSource = new com.oplus.tblplayer.upstream.TBLOkHttpDataSource(this.callFactory, this.userAgent, null, this.cacheControl, requestProperties);
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.listener;
        if (transferListener != null) {
            tBLOkHttpDataSource.addTransferListener(transferListener);
        }
        return tBLOkHttpDataSource;
    }
}
