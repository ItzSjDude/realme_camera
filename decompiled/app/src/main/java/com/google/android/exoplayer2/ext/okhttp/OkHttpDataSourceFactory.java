package com.google.android.exoplayer2.ext.okhttp;

/* loaded from: classes.dex */
public final class OkHttpDataSourceFactory extends com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory {
    private final okhttp3.CacheControl cacheControl;
    private final okhttp3.Call.Factory callFactory;
    private final com.google.android.exoplayer2.upstream.TransferListener listener;
    private final java.lang.String userAgent;

    public OkHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str) {
        this(factory, str, null, null);
    }

    public OkHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str, okhttp3.CacheControl cacheControl) {
        this(factory, str, null, cacheControl);
    }

    public OkHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(factory, str, transferListener, null);
    }

    public OkHttpDataSourceFactory(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.upstream.TransferListener transferListener, okhttp3.CacheControl cacheControl) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    public com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource createDataSourceInternal(com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource okHttpDataSource = new com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource(this.callFactory, this.userAgent, null, this.cacheControl, requestProperties);
        com.google.android.exoplayer2.upstream.TransferListener transferListener = this.listener;
        if (transferListener != null) {
            okHttpDataSource.addTransferListener(transferListener);
        }
        return okHttpDataSource;
    }
}
