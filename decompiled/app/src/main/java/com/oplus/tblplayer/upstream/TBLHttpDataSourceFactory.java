package com.oplus.tblplayer.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import okhttp3.CacheControl;
import okhttp3.Call;

/* loaded from: classes2.dex */
public final class TBLHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private final TransferListener listener;
    private final String userAgent;

    public TBLHttpDataSourceFactory(Call.Factory factory, String str) {
        this(factory, str, null, null);
    }

    public TBLHttpDataSourceFactory(Call.Factory factory, String str, CacheControl cacheControl) {
        this(factory, str, null, cacheControl);
    }

    public TBLHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener) {
        this(factory, str, transferListener, null);
    }

    public TBLHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener, CacheControl cacheControl) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource.BaseFactory
    protected HttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        TBLOkHttpDataSource tBLOkHttpDataSource = new TBLOkHttpDataSource(this.callFactory, this.userAgent, null, this.cacheControl, requestProperties);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            tBLOkHttpDataSource.addTransferListener(transferListener);
        }
        return tBLOkHttpDataSource;
    }
}
