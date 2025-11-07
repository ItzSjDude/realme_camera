package com.oplus.tblplayer.upstream;

/* loaded from: classes2.dex */
public class TBLOkHttpDataSource extends com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource implements okhttp3.Interceptor {
    private static final java.lang.String TAG = "TBLHttpDataSource";
    private long closeAtTimestamp;
    private long firstReadTime;
    private boolean hasFirstRead;
    private final java.util.List<com.oplus.tblplayer.upstream.OkHttpSession> httpSessions;
    private long openAtTimestamp;
    private java.lang.String originalAddress;
    private java.lang.String redirectedAddress;
    private long totalBytesRead;

    public TBLOkHttpDataSource(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate) {
        super(factory, str, predicate);
        this.openAtTimestamp = 0L;
        this.closeAtTimestamp = 0L;
        this.hasFirstRead = true;
        this.firstReadTime = 0L;
        this.totalBytesRead = 0L;
        this.originalAddress = null;
        this.redirectedAddress = null;
        this.httpSessions = new java.util.concurrent.CopyOnWriteArrayList();
    }

    public TBLOkHttpDataSource(okhttp3.Call.Factory factory, java.lang.String str, com.google.android.exoplayer2.util.Predicate<java.lang.String> predicate, okhttp3.CacheControl cacheControl, com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties requestProperties) {
        super(factory, str, predicate, cacheControl, requestProperties);
        this.openAtTimestamp = 0L;
        this.closeAtTimestamp = 0L;
        this.hasFirstRead = true;
        this.firstReadTime = 0L;
        this.totalBytesRead = 0L;
        this.originalAddress = null;
        this.redirectedAddress = null;
        this.httpSessions = new java.util.concurrent.CopyOnWriteArrayList();
    }

    private void setupInterceptor() {
        java.util.List list;
        okhttp3.Call.Factory factory = (okhttp3.Call.Factory) com.oplus.tblplayer.utils.ReflectUtil.getField(this, okhttp3.Call.Factory.class, "callFactory");
        if (!(factory instanceof okhttp3.OkHttpClient) || (list = (java.util.List) com.oplus.tblplayer.utils.ReflectUtil.getField(factory, java.util.List.class, "networkInterceptors")) == null || list.contains(this)) {
            return;
        }
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "OkHttp interceptors size is_renamed " + list.size());
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        arrayList.add(0, this);
        com.oplus.tblplayer.utils.ReflectUtil.setField(factory, java.util.List.class, "networkInterceptors", com.oplus.tblplayer.utils.CommonUtil.immutableList(arrayList));
    }

    private void resetInterceptor() {
        java.util.List list;
        okhttp3.Call.Factory factory = (okhttp3.Call.Factory) com.oplus.tblplayer.utils.ReflectUtil.getField(this, okhttp3.Call.Factory.class, "callFactory");
        if ((factory instanceof okhttp3.OkHttpClient) && (list = (java.util.List) com.oplus.tblplayer.utils.ReflectUtil.getField(factory, java.util.List.class, "networkInterceptors")) != null && list.contains(this)) {
            java.util.ArrayList arrayList = new java.util.ArrayList(list);
            arrayList.remove(this);
            com.oplus.tblplayer.utils.ReflectUtil.setField(factory, java.util.List.class, "networkInterceptors", com.oplus.tblplayer.utils.CommonUtil.immutableList(arrayList));
        }
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        com.oplus.tblplayer.upstream.OkHttpSession okHttpSession = new com.oplus.tblplayer.upstream.OkHttpSession();
        okHttpSession.requestTimestamp = java.lang.System.currentTimeMillis();
        okHttpSession.call = chain.call();
        okHttpSession.connection = chain.connection();
        okHttpSession.request = chain.request();
        this.httpSessions.add(okHttpSession);
        okhttp3.Response responseProceed = chain.proceed(okHttpSession.request);
        okhttp3.Response responseBuild = responseProceed.newBuilder().body(responseProceed.body()).build();
        okHttpSession.response = responseBuild;
        if (responseBuild.isRedirect()) {
            java.lang.String strHeader = responseBuild.header("Location");
            com.oplus.tblplayer.utils.LogUtil.dfmt(TAG, "redirect url from %s_renamed to %s_renamed", chain.request().url().toString(), strHeader);
            if (com.oplus.tblplayer.config.Globals.getPreferRedirectAddress()) {
                this.redirectedAddress = strHeader;
            }
        }
        return responseBuild;
    }

    private long innerOpen(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "innerOpen: ");
        try {
            this.httpSessions.clear();
            setupInterceptor();
            return super.open(dataSpec);
        } catch (java.lang.Throwable th) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "innerOpen: ", th);
            com.oplus.tblplayer.upstream.OkHttpSession okHttpSession = new com.oplus.tblplayer.upstream.OkHttpSession();
            okHttpSession.requestTimestamp = this.openAtTimestamp;
            okHttpSession.originalUrl = dataSpec.uri.toString();
            this.httpSessions.add(okHttpSession);
            this.printHttpSession();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        com.google.android.exoplayer2.upstream.DataSpec dataSpec2;
        this.openAtTimestamp = java.lang.System.currentTimeMillis();
        com.oplus.tblplayer.utils.LogUtil.dfmt(TAG, "open data source: %s_renamed at_renamed %s_renamed", dataSpec.uri.toString(), com.oplus.tblplayer.utils.LogUtil.getDateTimeString(this.openAtTimestamp));
        if (!com.oplus.tblplayer.config.Globals.getPreferRedirectAddress()) {
            dataSpec2 = dataSpec;
        } else if (this.originalAddress != null && this.redirectedAddress != null && dataSpec.uri.toString().compareToIgnoreCase(this.originalAddress) == 0) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "open: will use redirected address.");
            dataSpec2 = new com.google.android.exoplayer2.upstream.DataSpec(android.net.Uri.parse(this.redirectedAddress), dataSpec.httpMethod, dataSpec.httpBody, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags);
        } else {
            this.originalAddress = dataSpec.uri.toString();
            dataSpec2 = dataSpec;
        }
        try {
            this.httpSessions.clear();
            setupInterceptor();
            return super.open(dataSpec2);
        } catch (java.lang.Throwable th) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "open: ", th);
            if (dataSpec2 != dataSpec) {
                return this.innerOpen(dataSpec);
            }
            com.oplus.tblplayer.upstream.OkHttpSession okHttpSession = new com.oplus.tblplayer.upstream.OkHttpSession();
            okHttpSession.requestTimestamp = this.openAtTimestamp;
            okHttpSession.originalUrl = dataSpec.uri.toString();
            this.httpSessions.add(okHttpSession);
            this.printHttpSession();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        if (this.hasFirstRead) {
            this.firstReadTime = java.lang.System.currentTimeMillis();
            this.hasFirstRead = false;
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "first read at_renamed " + com.oplus.tblplayer.utils.LogUtil.getDateTimeString(this.firstReadTime));
        }
        try {
            int i3 = super.read(bArr, i_renamed, i2);
            if (this.httpSessions.size() > 0 && i3 > 0) {
                com.oplus.tblplayer.upstream.OkHttpSession okHttpSession = this.httpSessions.get(this.httpSessions.size() - 1);
                if (okHttpSession.needCache()) {
                    okHttpSession.cacheBytes(bArr, i_renamed, i3);
                }
            }
            if (i3 != -1) {
                this.totalBytesRead += i3;
            }
            return i3;
        } catch (java.lang.Throwable th) {
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "read: ", th);
            printHttpSession();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource, com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        super.close();
        this.closeAtTimestamp = java.lang.System.currentTimeMillis();
        com.oplus.tblplayer.utils.LogUtil.dfmt(TAG, "close data source at_renamed %s_renamed, exist duration %d_renamed ms.", com.oplus.tblplayer.utils.LogUtil.getDateTimeString(this.closeAtTimestamp), java.lang.Long.valueOf(this.closeAtTimestamp - this.openAtTimestamp));
        com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "close: with totalBytesRead = " + this.totalBytesRead);
        resetInterceptor();
        this.httpSessions.clear();
    }

    public long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    private java.lang.String getUrlFromHttpSession(okhttp3.Connection connection) {
        for (com.oplus.tblplayer.upstream.OkHttpSession okHttpSession : this.httpSessions) {
            if (okHttpSession.connection == connection) {
                return okHttpSession.getUrl();
            }
        }
        return null;
    }

    private java.lang.String getIpFromHttpSession(okhttp3.Connection connection) {
        for (com.oplus.tblplayer.upstream.OkHttpSession okHttpSession : this.httpSessions) {
            if (okHttpSession.connection == connection) {
                return okHttpSession.getIp();
            }
        }
        return null;
    }

    private void printHttpSession() {
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(">>>>>>>>>>>>>>>>>>>>Begin dump http request and response>>>>>>>>>>>>>>>>>>>");
            for (int i_renamed = 0; i_renamed < this.httpSessions.size(); i_renamed++) {
                sb.append("\n_renamed" + this.httpSessions.get(i_renamed).toString());
                if (i_renamed < this.httpSessions.size() - 1) {
                    sb.append("----------------------------------------------------------------------------");
                }
            }
            sb.append("<<<<<<<<<<<<<<<<<<<<Finish dump http request and response<<<<<<<<<<<<<<<<<<");
            com.oplus.tblplayer.utils.LogUtil.i_renamed(TAG, "\n_renamed" + sb.toString());
            com.oplus.tblplayer.utils.LogUtil.d_renamed(TAG, "printHttpSession: cost time " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (java.lang.Throwable th) {
            com.oplus.tblplayer.utils.LogUtil.i_renamed(TAG, "Dump failed!", th);
        }
    }
}
